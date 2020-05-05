package shop;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Ex2Tests {
	
	public static final double TOLERANCE = 0.00001;
	private Product 		milk;
	private Product 		bread;
	private Product 		apples;
	private MultiBuyProduct tomato;
	private ShoppingCart 	testshop;
	
	@Before
	public void setup() {
		
		testshop = new ShoppingCart();
		
		milk 	= new Product("Milk (1l)", 1.12, 2);
		bread	= new Product("Bread", 0.78, 2);
		apples 	= new Product("Apples", 0.49, 4);
		tomato 	= new MultiBuyProduct ("Tomato", 0.5, 20, 10, 3);
		
		testshop.add(milk);
		testshop.add(bread);
		testshop.add(apples);
		testshop.add(tomato);
		
	}
	
	// Testing price getter of Product
	@Test
	public void test1() {
		
		double expectedpricemilk = 1.12;
		double actualpricemilk = milk.getPrice();
		assertEquals(expectedpricemilk, actualpricemilk, TOLERANCE);
	}
	
	// Testing quantity getter of Product
	@Test
	public void test2() {
		
		int expectedquantitymilk = 2;
		int actualquantitymilk = milk.getQuantity();
		assertEquals(expectedquantitymilk, actualquantitymilk);
	}
	
	//Testing price setter of Product
	@Test
	public void test3() {
		
		milk.setPrice(2.15);
		double expectedpricemilk = 2.15;
		double actualpricemilk = milk.getPrice();
		assertEquals(expectedpricemilk, actualpricemilk, TOLERANCE);
	}
	
	//Testing price setter of Product throws illegal argument exception if the price is under zero
	@Test(expected = IllegalArgumentException.class)
	public void test4() {
			
		milk.setPrice(-2.15);
			
	}
	
	//Testing price setter of Product throws illegal argument exception if the price is under zero
	@Test(expected = IllegalArgumentException.class)
	public void test5() {
				
		milk.setPrice(0);
	
	}
	
	// Testing getter of minimum discount quantity for a MultiBuyProduct
	@Test
	public void test6() {
			
		int expectedpricetomato = 10;
		int actualpricetomato = tomato.getMinDiscountedQuantity();
		assertEquals(expectedpricetomato, actualpricetomato);
	}
	
	// Testing getter of minimum discount quantity for a MultiBuyProduct
	@Test
	public void test7() {
				
		int expectedpricetomato = 3;
		int actualpricetomato = tomato.getDiscountPercent();
		assertEquals(expectedpricetomato, actualpricetomato);
	}
	
	// Testing setter of minimum discount quantity for a MultiBuyProduct
	@Test
	public void test8() {
		
		tomato.setMinDiscountedQuantity(20);
		int expectedmindiscountedquantitytomato = 20;
		int actualmindiscountedquantitytomato = tomato.getMinDiscountedQuantity();
		assertEquals(expectedmindiscountedquantitytomato, actualmindiscountedquantitytomato);
	}
	
	// Testing setter of discount percentage for a MultiBuyProduct
	@Test
	public void test9() {
			
		tomato.setDiscountPercent(18);
		int expecteddiscountpercenttomato = 18;
		int actualdiscountpercenttomato = tomato.getDiscountPercent();
		assertEquals(expecteddiscountpercenttomato, actualdiscountpercenttomato);
		}
		
	//Testing minimum discount quantity setter of MultiBuyProduct throws illegal argument exception if set to zero
	@Test(expected = IllegalArgumentException.class)
	public void test10() {
				
		tomato.setMinDiscountedQuantity(0);
	}
	
	//Testing minimum discount quantity setter of MultiBuyProduct throws illegal argument exception if set to a negative number
	@Test(expected = IllegalArgumentException.class)
	public void test11() {
					
		tomato.setMinDiscountedQuantity(-2);
	}
	
	//Test add to cart is updating quantity of milk rather than adding it to the cart as a separate product
	@Test
	public void test12() {
		
		testshop.add(milk);
		int expectedquantitymilk = 4;
		int actualquantitymilk = milk.getQuantity();
		assertEquals(expectedquantitymilk, actualquantitymilk);
	}
	
	//Test add to cart is not growing the size of the array list either when more milk is added
	@Test
	public void test13() {
		
		testshop.add(milk);
		int expectedarraylistsize = 4;
		int actualarraylistsize = testshop.getCart().size();
		assertEquals(expectedarraylistsize, actualarraylistsize);
	}
	
	//Test to check when a new cart is made that the arrayList is empty
	@Test
	public void test14() {
			
		ShoppingCart testshop2 = new ShoppingCart();
		
		int expectedarraylistsize = 0;
		int actualarraylistsize = testshop2.getCart().size();
		assertEquals(expectedarraylistsize, actualarraylistsize);
	}
	
	//Test to check that when a product is added to an empty arraylist of products, it is added.
	@Test
	public void test15() {
				
		ShoppingCart testshop2 = new ShoppingCart();
		testshop2.add(milk);
		int expectedarraylistsize = 1;
		int actualarraylistsize = testshop2.getCart().size();
		assertEquals(expectedarraylistsize, actualarraylistsize);
	}
	
	//Test to check that when four different products are added, the size of the cart is correct containing 4 products.
	@Test
	public void test16() {
					
		ShoppingCart testshop2 = new ShoppingCart();
		testshop2.add(milk);
		testshop2.add(bread);
		testshop2.add(apples);
		testshop2.add(tomato);
		
		int expectedarraylistsize = 4;
		int actualarraylistsize = testshop2.getCart().size();
		assertEquals(expectedarraylistsize, actualarraylistsize);
	}
	
	
	
}