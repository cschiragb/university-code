package shop;

import java.util.ArrayList;

/**
 * The class ShoppingCart creates the profile of a cart containing products of type Product
 * No field variables are established, the class only has an arrayList of products.
 * 
 * @author Chirag Bhatti
 * @version 2018-12-06
 *
 */
public class ShoppingCart {

	private ArrayList<Product> cart;

	/**
	 * ShoppingCart is a parameterless constructor to the create the profile of a cart.
	 * The cart is a new ArrayList of products with type Product (superclass) or MultiBuyProduct (subclass).
	 */
	public ShoppingCart() {
		this.cart = new ArrayList<Product>();
	}

	/**
	 * add is a method to add products to the ArrayList of type Product for a given ShoppingCart
	 * 
	 * If the cart is empty, the product is added straightaway.
	 * 
	 * If the cart already contains the same product (in name and price), then the quantity of that
	 * product is updated to reflect the addition of the product. 
	 * Otherwise the product is added to the cart because it is not already in the cart.
	 * 
	 * @param p is the product to be added to the cart of type Product
	 */
	public void add(Product p) {
		
		if (cart.size() < 1) {
			cart.add(p);
			
		} else {
			
			for (int i = 0; i < cart.size(); i++) {
			
				if (cart.get(i).getName().equals(p.getName()) == true && cart.get(i).getPrice() == p.getPrice()) {
					
					cart.get(i).setQuantity(cart.get(i).getQuantity() + p.getQuantity());
					break;
					
				} else if (i == cart.size()-1) {
					
					cart.add(p);
					break;
				}
			}
		}
	}
	
	/**
	 * 
	 * @return the arrayList cart containing the products in the cart
	 */
	public ArrayList<Product> getCart() {
		return cart;
	}
	
	/**
	 * toString method for printing the details of a shopping cart containing products
	 * @return details of each product in the shopping cart, considering whether they
	 * are ordinary products or MutliBuyProducts eligible for a discount. Finally, 
	 * provide the overall cost of the products at the bottom.
	 */
	public String toString() {

		/*
		 * Initialise the total price of all products to zero
		 */
		double overallprice = 0.0;
		
		/*
		 * Use a string builder to build up the string
		 */
		StringBuilder cartitems = new StringBuilder();

		/*
		 * Loop through all the items on the arrayList of the shopping cart.
		 * First get the total price of each product and add it to the overall price.
		 * Secondly, call the specific toString on each item and append this using the string builder.
		 * This will utilise either the toString in the superclass Product, or the subclass
		 * MultiBuyProduct.
		 */
		for (int i = 0; i < cart.size(); i++) {
			
			overallprice += cart.get(i).getTotalPrice();
			
			cartitems.append(cart.get(i).toString());
		}
		
		/*
		 * Adds a line separation between the individual products to be printed and the overall price
		 * for the products to be purchased in the shopping cart
		 */
		
		cartitems.append(String.format("%2s %1s %3s %12s %-12s %5s %3s %12s", 
		 		"", "", "", "", "", "", "--------------------", ""));
		
		/*
		 * Make a new line between the line separation for the details regarding the total price
		 */
		cartitems.append("\n");
		
		/*
		 * Adds the details of the overall price of all the products in the shopping cart
		 */
		cartitems.append(String.format("%2s %1s %3s %12s %-12s %5s %3s %10.2f", 
		 		"", "", "", "", "", "", "TOTAL GBP", overallprice));	
		
		return cartitems.toString();
	}

}
