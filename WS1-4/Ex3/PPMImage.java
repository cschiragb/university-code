import java.io.*;
import java.util.Scanner;

/** PPMImage is a class to convert a colour PPM image into a grayscale
 * PGM Image
 * 
 * The class converts a colour image that is read in from a supplied PPM file
 * into a grayscale image. 
 * A separate method is used to calculate the average of the RGB values 
 * in order to calculate the grayscale values to create the grayscale version.
 * 
 * We establish five field variables:
 * width 		- is the number of columns the image has with values
 * height 		- is the number of rows the image has with values
 * maxShade 	- is the maximum permitted value for the RGB and GrayScale values
 * typeOfFile 	- is the identifier classifying the image format. Typically P3 for
 * 				  RGB colour and P2 for Grayscale
 * pixels		- is a 3D array with the RGB values at each pixel representation
 * 
 * @author Chirag Bhatti
 * @version 08/11/2018
 */

public class PPMImage{
    private int width;
    private int height;
    private int maxShade;
    private String typeOfFile;
    private short[][][] pixels;

    /** PPMImage is a constructor to create the profile of a PPMImage
     * 
     *  @param filename is the name of the PPM file that is to be read in
     *  order to construct the profile of the image
     */
    public PPMImage(String filename) {
        
    	/* 
    	 * we setup a try in case the PPM Image file we are looking for does not exit 
    	 */
    	try { 
        
    		/* 
    		 * we setup a new scanner to read in a PPM Image with known filename 
    		 */
        	Scanner s = new Scanner(new File(filename)); 
        
        	/* 
        	 * A standard PPM Image has in it's header the type of file as a String
        	 * on its first line. We read in this String and set it into the typeOfFile. 
        	 */
            	typeOfFile = s.next();
            	
            /* 
             * The type of file is followed by two subsequent integers representing the
             * width and height of the image (in that order). We read those values in 
             * consecutively and set them as the width and height variables accordingly.
             */
            	width = s.nextInt();
            	height = s.nextInt();
            	
            /*
             * Finally, it is known the integer following the dimensions is the maximum
             * shade value (typically 255) applicable to the picture. 
             * We read in this value and set it as the maxShade.
             */
            	maxShade = s.nextInt();
            
            /*
             * We initialise an array pixels with dimensions height and width and depth.
             * As we know the PPM Image is RGB, we can say the 3rd dimension (the depth) 
             * is always 3 in size also, each representing the red, green, blue values
             * at each pixel position defined within height and width.	
             */
            	pixels = new short[height][width][3];
            		
            	/*
            	 * We use a for loop to go through the remaining values stored in the scanned 
            	 * file and place them in their correct positions within the pixels array,
            	 * in order to get a profile of the image in RGB. i.e. we populate all the shade
            	 * values for red-green-blue within our pixels array.
            	 * 
            	 * LOOP INVARIANT: 0 <= pixels[i][j][k] <= maxShade.
            	 */
            	for (int i=0; i<height; i++){
            		for (int j=0; j<width; j++){
            			for (int k=0; k<3; k++){
            				pixels[i][j][k] = s.nextShort();
            			}
            		}
            	}
            	/*
            	 * Close the scanner 's' to prevent a resource leak
            	 */
            	s.close();
    	}
        
        /*
         * We setup a catch in case the image cannot be found, and hence print an error message 
         * and create an empty image
         */
        catch (IOException e){
        	
            System.out.println("File not found.");

            typeOfFile = "P3";
            width = 0;
            height = 0;
            maxShade = 0;
            pixels = new short[width][height][3];
        }
    }

    /**
     *  @return The width of the image as an integer
     */
    public int getWidth(){
        return width;
    }

    /**
     *  @return The height of the image as an integer
     */
    public int getHeight(){
        return height;
    }
    
    /**
     *  @return The maximum shade value of the image as an integer
     */
    public int getMaxShade(){
        return maxShade;
    }

    /**
     *  @return The file type of the image as a String
     */
    public String getTypeOfFile(){
        return typeOfFile;
    }

    /**
     *  @return The array representing the image pixels and their short format RGB shade values
     */
    public short[][][] getPixels(){
        return pixels;
    }

    /**
     *  The method converts the colour image RGB values into single grayscale values, 
     *  thereby converting the image to grayscale.
     *  
     *  @param filename The filename of the file in which the grayscale version
     *  should be saved.
     */
    public short[][] makeGrey (String filename){
    	
    	/* a new grayscale image array is initialised with the same width and height as the
    	 * colour PPM image read in above
    	 */
    	short[][] grayimage = new short [getHeight()][getWidth()];
    	
    	
    	try{
    		
    	/*
    	 * We setup a try for a buffered writer and file writer, to allow us to build and create the 
    	 * greyscale image
    	 */
    		BufferedWriter out = new BufferedWriter(new FileWriter(filename));
    		
	    		/*
	    		 * For a grey PGM image, the file type is P2 so we write this out into the
	    		 * header on the first line and then move down a line.
	    		 */
	    		out.write("P2" + "\n");

	    		/* 
	    		 * Next we write the dimensions out into the header on the same line,
	    		 * and then move down another line. 
	    		 */
	    		out.write((getWidth()) + " " + (getHeight()) +"\n");
	    
	    		/* 
	    		 * We write the max shade number next. In this case, it will be the same as the PPM image
	    		 * it is being converted from. I.e. gray and RGB limits are both 255. We then move onto the
	    		 * next line.
	    		 */
	    		out.write(getMaxShade() + "\n");
    	
	    		/*
	    		 * Next we initialise a byte counter to 0.
	    		 */
	    		byte counter = 0;
	    
	    		/*
	    		 * We now start extracting the colours values by looping through the pixels array of the colour 
	    		 * PPM image that was scanned in, in order to determine the grayscale numbers to be used for each
	    		 * pixel in our new PGM image. We write these determined grayscale values into our separate
	    		 * grayscale array, and write the values from the array into our grayscale image file.
	    		 * Whenever 15 entries have been made by the writer, the writer moves to a new line and resets
	    		 * the counter to 0.
	    		 * 
	    		 * LOOP INVARIANT: 0 <= colourAverage <= 255
	    		 */
	    		for (int i = 0; i<getHeight(); i++){
	    			for (int j = 0; j<getWidth(); j++){
		    	
	    				double red 				= getPixels() [i][j][0];
	    				double green 			= getPixels() [i][j][1];
	    				double blue 			= getPixels() [i][j][2];
	    				
	    				double colourAverage 	= Math.round (((double) (red + green + blue)) / 3.0);
	    				grayimage[i][j] 		= (short) colourAverage;
	    				
	    				out.write(grayimage[i][j] + " ");
	    				
	    				counter++;
	    					
	    				if (counter == 15){
	    					
	    					out.write("\n");
	    					counter = 0;
	    					
	    				}
	    			}
	    		}
    		
	    	/*
	    	 * Finally, we put a new line in at the end and close the file being written into.
	    	 */
	    	out.write("\n");
	    	out.close();
    	}
    	
    	/*
    	 * A catch is used if their is an error creating the grayscale image file
    	 */
    	catch (IOException e){
    		
    		System.out.println("Error creating grayscale image file");
    	}
    	
    /* 
     * Finally, the array containing all the grayscale images is returned
     */
    return grayimage;
    }	
}
