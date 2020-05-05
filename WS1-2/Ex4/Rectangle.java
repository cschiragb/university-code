
public class Rectangle {

	/** 
	 *  The original code was buggy because the their was no calculation of the area in terms of width and height incorporated.
	 *  We set a field variable area, but we did not have a method to calculate the area in either the constructor or in a separate method.
	 *  Instead all that was setup was that the field variable area was equal to the instance variable area in the setter, and the getter
	 *  would obtain this area set. The constructor only initialised the field variable area as just equal to area.
	 *  The code was corrected by incorporating a getter / method for calculating the area, which was calculated by the get of the width multiplied
	 *  by the get of the height. The result of getArea was then called in the toString method to give the desired result.
	 *  Please see code below for corrections.
	 *
	 *  We define a rectangle by the two field variables width and height,
	 *  each of type double. Furthermore, we write getters and
	 *  setters for the two fields as well as a toString method, in addition
	 *  to a method for computing the area. 
	 *  We test it in a main method.
	 *
	 *  @version 2018-10-24
	 *  @author Chirag Bhatti (adapted from Manfred kerber's code)
	 */

	    private double width;
	    private double height;

	    /**
	     *  <pre>
	     *                 width
	     *  +--------------------------------------+
	     *  |                                      |
	     *  |                                      |
	     *  |       area = width * height          |  height
	     *  |                                      |
	     *  |                                      |
	     *  +--------------------------------------+
	     *  </pre>
	     *  @param width The width of the rectangle.
	     *  @param height The height of the rectangle.
	     *  @param area The area of the rectangle.
	     */
	    public RectangleCorrected(double width, double height) {
	        this.width  = width;
	        this.height = height;
	    }

	    /**
	     *  Getter for the width.
	     *  @return The width of the rectangle is returned.
	     */ 
	    public double getWidth() {
	        return width;
	    }

	    /**
	     *  Getter for the height.
	     *  @return The height of the rectangle is returned.
	     */ 
	    public double getHeight() {
	        return height;
	    }
	    
	    /** 
	     * Getter for the area
	     * @return The area of the rectangle based on the getter values of the width and the height
	     */
	    public double getArea() {
	    	return getWidth() * getHeight();
	    }

	    /**
	     *  Setter for the width. The width of the rectangle is updated.
	     *  @param width The new width of the updated rectangle.
	     */ 
	    public void setWidth(double width) {
	        this.width = width;
	    }

	    /**
	     *  Setter for the height. The height of the rectangle is updated.
	     *  @param height The new height of the updated rectangle.
	     */ 
	    public void setHeight(double height) {
	        this.height = height;
	    }

	    
	    /**
	     * @return A human readable description of the rectangle in form
	     *     of the three field variables specifying it.
	     */ 
	    public String toString() {
	        return "The rectangle has a width of " + width +
	            ", a height of " + height +
	            ", and an area of " + getArea() + ".";
	    }

	    /*
	     *  main method with a test of the setHeight setter and the
	     *  toString method.
	     */
	    public static void main(String[] args) {
	        RectangleCorrected r = new RectangleCorrected(2, 4);
	        System.out.println(r);
	        r.setHeight(5);
	        System.out.println(r);
	    }
	}

