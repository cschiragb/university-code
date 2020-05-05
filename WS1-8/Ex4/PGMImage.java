import java.io.*;
import java.util.Scanner;

/**
 *  The class creates an image in form of a greyscale image which is
 *  read in from a file. It contains a method that is supposed to
 *  rotate the image and write it out again. However, it does not work
 *  properly, the images written out do not show anything meaningful.
 *
 *  @version 2018-11-19
 *  @author Manfred Kerber
 *  
 *  The problem with this class, was the way in which the rotated image
 *  pixels were being written into the the new file for the rotated image,
 *  using the buffered writer.
 *  
 *  As the image is being rotated 90deg CW, the height and the width must
 *  swap in the loop. Therefore i < getWidth() rather than getHeight(), 
 *  and conversely the same is true for j < getHeight() rather than width.
 *  This will ensure that the correct sized rotated image can be generated
 *  without creating an array out of bounds error.
 *  
 *  Correction:
 *  for (int i=0; i<getWidth(); i++) {
 *               for (int j=0; j<getHeight(); j++){
 *              
 *  Before:
 *  for (int i=0; i<getHeight(); i++) {
 *              for (int j=0; j<getWidth(); j++){
 *  
 *  Next taking the array of pixels from the original image, when we rotate
 *  a matrix of numbers, the first column of numbers becomes the first row
 *  of numbers in the rotated matrix. Similarly, the bottom left index becomes
 *  the top left index. The top left index becomes the top right index, and 
 *  so on and so forth.
 *  
 *  Therefore we must modify the way we read in the from the existing pixels
 *  array in order to follow this rule / pattern.
 *  
 *  To read in from the bottom of a column upwards, and write in the bottom 
 *  value of the column as the first value of a row in the new image, 
 *  we most modify how we read across from the getPixels() array into the writer.
 *  
 *  We write:
 *  out.write(getPixels()[getHeight()-j-1][i] + " ");
 *  
 *  Instead of:
 *  out.write(getPixels()[i][j] + " ");
 *  
 *  This works because the first of part of a "[][] PGM array" are actually the column pixels.
 *  Considering the code is nested inside of an j loop, which is nested in an i loop.
 *  Therefore when i = 0 and j = 0, we go to the bottom left of the getPixels() array.
 *  As j increases, the equation means we read up the first column.
 *  As i increases, we move to the next column, again with j = 0 we start from the bottom.
 *  
 *  This way we can follow our pattern of converting columns bottom to top, 
 *  into rows left to right equivalently for the creation of the rotated image.
 *  
 *  @author Chirag Bhatti
 *  @version 2018-12-06
 */
public class PGMImage{
    private int width;
    private int height;
    private int maxShade;
    private String typeOfFile;
    private short[][] pixels;

    /**
     *  @param filename The name of a file that contains an image in
     *  pgm format of type P2.
     *
     */
    public PGMImage(String filename) {
        // try since the file may not exist.
        try {
            // we read from the scanner s which is linked to the file filename.
            Scanner s = new Scanner(new File(filename));

            /* The field variables are assigned by reading in from a
               file. The file should start with something like
               P2
               150 176
               255

               where P2 is the file type, 150 the width of the image, 176
               the height, and 255 the maximal grey value. Then follow
               150*176 grey values between 0 and 255.
            */
    
            // We read the initial element that is in our case "P2"
            typeOfFile = s.next();
            // Next we read the width, the height, and the maxShade.
            width = s.nextInt();
            height = s.nextInt();
            maxShade = s.nextInt();
            //We initialize and read in the different pixels.
            pixels = new short[height][width];
            for (int i=0; i<height; i++){
                for (int j=0; j<width; j++) {
                    pixels[i][j] = s.nextShort();
                }
            }
        }
        catch (IOException e){
            //If the file is not found, an error message is printed,
            //and an empty image is created.
            System.out.println("File not found.");

            typeOfFile = "P2";
            width = 0;
            height = 0;
            maxShade = 0;
            pixels = new short[width][height];
        }
    }

    /**
     *  @return The width of the image.
     */
    public int getWidth(){
        return width;
    }

    /**
     *  @return The height of the image.
     */
    public int getHeight(){
        return height;
    }
    
    /**
     *  @return The maximal grey value of the image.
     */
    public int getMaxShade(){
        return maxShade;
    }

    /**
     *  @return The file type of the image.
     */
    public String getTypeOfFile(){
        return typeOfFile;
    }

    /**
     *  @return The matrix representing the pixels of the image.
     */
    public short[][] getPixels(){
        return pixels;
    }


    /**
     *  The method is to rotate a PGMImage by 90 degrees clockwise.
     *  There is a problem with the method and the rotated images are
     *  not correct.
     *  @param filename The filename of the file in which the rotated
     *  image should be saved.
     */
    public void rotate (String filename){
	try {
	    BufferedWriter out = 
		new BufferedWriter(new FileWriter(filename));
	    // We write the file type to out.
	    out.write(getTypeOfFile() + "\n");

	    // We write the dimensions to out. This writes the width as the scanned in height, and height as the scanned in width from the original image.
	    out.write(getHeight() + " " + getWidth() +"\n");
	    
	    // We write maximal number.
	    out.write(getMaxShade() + "\n");
	    
	    byte counter = 0;
            for (int i=0; i<getWidth(); i++) {
                for (int j=0; j<getHeight(); j++){
                    out.write(getPixels()[getHeight()-j-1][i] + " ");
                    counter++;
                    if (counter == 15){		 
                        out.write("\n"); // in order not to have too long lines
			counter = 0;
		    }
                }
            }
            out.write("\n");
	    // We close the file.
	    out.close();
	}
	catch (IOException e){
            //Errors are caught.
            System.out.println("File not found.");
        }
    }

    /*
     * An example.
     */
    public static void main(String[] args) {
        PGMImage cs = new PGMImage("ComputerScience.pgm");
        cs.rotate("ComputerScienceRotate.pgm");
    }
}
