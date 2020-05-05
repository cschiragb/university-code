package shop;

/**
 * The class Product creates the profile of a product to be purchased
 * We establish three field variables:
 * 
 * name 	- is the name of the product of type String
 * price 	- is the cost of the product per single quantity of type double
 * quantity - is the amount of the product to be bought of type int
 * 
 * @author Chirag Bhatti
 * @version 2018-12-06
 */
public class Product {
	
	private String 	name;
	private double 	price;
	private int 	quantity;
	
	
	/**
	 * Product is a constructor to create the profile of a product
	 * 
	 * @param name is the name of the product of type String
	 * @param price is the cost of the product of type double
	 * @param quantity is the amount of product to be bought of type int
	 */
	public Product(String name, double price, int quantity) {
		this.name 		= name;
		this.price 		= price;
		this.quantity 	= quantity;
	}
	
	
	/**
	 * 
	 * @return the name of the product as a String
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * 
	 * @return the price of a product as a number of type double
	 */
	public double getPrice() {
		return price;
	}
	
	
	/**
	 * 
	 * @return the amount of product to be bought as a number of type int
	 */ 
	public int getQuantity() {
		return quantity;
	}

	
	/**
	 * Sets the name of the product 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Sets the price of a product as long as it is above zero, otherwise
	 * throws an argument exception.
	 * @param price
	 */
	public void setPrice(double price) {
		
		if (price <= 0) {
			
			throw new IllegalArgumentException();
			
		} else {
			
			this.price = price;
		}
	}

	
	/**
	 * Sets the amount of product to be bought as long as it is above zero,
	 * otherwise throws an argument exception.
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		
		if (quantity <= 0) {
			
			throw new IllegalArgumentException();
			
		} else {
			
			this.quantity = quantity;
		}
	}

	
	/**
	 * getTotalPrice is a method to calculate the total cost of the product depending on
	 * the price of the product and the quantity to be bought
	 * @return the calculation of the price * quantity
	 */
	public double getTotalPrice() {
		return getPrice() * getQuantity();
	}
	
	
	/**
	 * toString method for printing the details of a product to a ShoppingCart
	 * @return productbuy as a String containing details of the product purchase specifics.
	 * This provides the quantity, price per single quantity, name of the product and the total price
	 * in a standard format.
	 */
	public String toString() {
		
		/*
		 * Use a string builder to build up the string
		 */
		StringBuilder productbuy = new StringBuilder();
		
		/*
		 * format the quantity, price, name and total price of the product in a standard way
		 */
		productbuy.append(String.format("%2s %1s %3s %10.2f %-20s %5s %3s %10.2f", 
							 			getQuantity(), "*", "GBP", getPrice(), getName(), "=", "GBP", getTotalPrice() ));
		/* 
		 * add a new line to the string for any additional products
		 */
		productbuy.append("\n"); 
		
		return productbuy.toString();
	}
}
