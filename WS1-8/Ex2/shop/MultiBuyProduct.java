package shop;

/**
 * The class MultiBuyProduct creates the profile of a product to be purchased
 * that comes with multi buy discounts.
 * The class is a sub-class of the class Product
 * 
 * We inherit three field variables:
 * 
 * name 	- is the name of the product of type String
 * price 	- is the cost of the product per single quantity of type double
 * quantity - is the amount of the product to be bought of type int
 * 
 * We define two further field variables:
 * minDiscountedQuantity 	- is the minimum quantity that has be bought to get a multibuy discount of type int
 * discountPercent			- is the amount of discount one gets if the minimum discounted quantity is bought, of type int
 * 
 * @author Chirag Bhatti
 * @version 2018-12-06
 *
 */
public class MultiBuyProduct extends Product {

	private int minDiscountedQuantity;
	private int discountPercent;
	
	
	/**
	 * MultiBuyProduct is a constructor to create the profile of a multibuy product
	 * 
	 * @param name is the name of the product of type String
	 * @param price price is the cost of the product of type double
	 * @param quantity is the amount of product to be bought of type int
	 * @param minDiscountedQuantity is the minimum of product that has to be bought to get the discount of type int
	 * @param discountPercent is the amount of discount as a percentage of the total price one gets for multibuy of type int
	 */
	public MultiBuyProduct(String name, double price, int quantity, int minDiscountedQuantity, int discountPercent) {
		super(name, price, quantity);
		this.minDiscountedQuantity 	= minDiscountedQuantity;
		this.discountPercent 		= discountPercent;
	}
	
	
	/**
	 * 
	 * @return the minimum quantity required to be purchased get the multibuy discount as an int
	 */
	public int getMinDiscountedQuantity() {
		return minDiscountedQuantity;
	}

	
	/**
	 * 
	 * @return the percentage discount off the total price as an int
	 */
	public int getDiscountPercent() {
		return discountPercent;
	}
	
	
	/**
	 * This method calculates the saving made in total due to qualifying for a multibuy discount
	 * @return the saving made in total due to the multibuy discount 
	 */
	public double getSaving() {
		return (super.getPrice() * super.getQuantity()) - getTotalPrice();
	}

	
	/**
	 * Sets the minimum quantity required to be purchased to get the multibuy discount, as
	 * long as the minimum quantity is above zero, otherwise throws an argument exception.
	 * @param minDiscountedQuantity
	 */
	public void setMinDiscountedQuantity(int minDiscountedQuantity) {
		
		if (minDiscountedQuantity <= 0) {
			
			throw new IllegalArgumentException();
			
		} else {
			
		this.minDiscountedQuantity = minDiscountedQuantity;
		
		}
	}

	
	/**
	 * Sets the percentage discount off the total price , as long as the discount percent is
	 * above zero, otherwise throws an argument exception.
	 * @param discountPercent
	 */
	public void setDiscountPercent(int discountPercent) {
		
		if (discountPercent <=0) {
			
			throw new IllegalArgumentException();
			
		} else {
			
			this.discountPercent = discountPercent;
			
		}
	}
	
	
	/**
	 * This method overrides the method from the superclass for calculating the total price
	 * Calculates the total price depending on the purchased quantity.
	 * If the quantity bought is equal to or more than the minimum quantity required for the discount, 
	 * the discount is applied to the total price.
	 * Otherwise, the total price is simple the price per item multiplied by the quantity, 
	 * no discount applied.
	 * 
	 * @return the total price of the product that is eligible for multibuy discount
	 */
	@Override
	public double getTotalPrice() {
		
		if (super.getQuantity() >= minDiscountedQuantity) {
			return super.getPrice() * super.getQuantity() * (1 - (discountPercent/100.0));
			
		} else {
			return super.getPrice() * super.getQuantity();
		}
	}	
	
	
	/**
	 * toString method for printing the details of a multibuyproduct to a ShoppingCart
	 * 
	 * The details of a product defined in the superclass Product toString are utilised to print the general details.
	 * If the amount to be purchased qualifies for a multibuy discount, the total saving made is added to the line below.
	 * Otherwise, the user is giving a message saying no multibuy discount has been applied, and the number of items 
	 * more they would need to purchase in order to qualify for the discount.
	 * 
	 * @return productbuy as a String containing details of the product to be bought, whether a multibuy discount has or hasn't 
	 * been made, and if a discount has been made, then the total saving as a result is also provided.
	 */
	@Override
	public String toString() {
		
		/* 
		 * Check if the product quantity qualifies for a multibuy discount
		 */
		if (super.getQuantity() >= minDiscountedQuantity) {
			
			/*
			 * Uses a string builder to build up the string
			 */
			StringBuilder multibuy = new StringBuilder();
			
			/*
			 * Details of a standard product are added to the string first
			 */
			multibuy.append(super.toString());
			
			/*
			 * if qualifying for a discount, the discount details are added to the string here
			 */
			multibuy.append(String.format("%1s %20s %5.2f", 
										  " " , "(Multibuy Discount:  GBP", getSaving() ));
			
			/*
			 * A closing bracket to close off the discount details
			 */
			multibuy.append(")");
			
			/*
			 * A new line is added in case of further products to be listed on the string
			 */
			multibuy.append("\n");
			
			return multibuy.toString();
			
		} else {
			
			/*
			 * Use a string builder to build up the string
			 */
			StringBuilder multibuy = new StringBuilder();
			
			/*
			 * Details of a standard product are added to the string first
			 */
			multibuy.append(super.toString());
			
			/*
			 * As the product could but isn't qualifying for a discount, a string showing
			 * no discount has been applied, and the number of products more that need to be purchased
			 * to be eligible, is added.
			 */
			multibuy.append(String.format("%1s %20s %3s", 
										  " " , "(No Multibuy Discount - buy this more quantity to get discount:", 
										  (getMinDiscountedQuantity()-super.getQuantity()) ));
			
			/*
			 * A closing bracket to close off the discount details
			 */
			multibuy.append(")");
			
			/* 
			 * A new line is added in case of further products to be listed on the string
			 */
			multibuy.append("\n");	
			
			return multibuy.toString();
		}
	}
}
