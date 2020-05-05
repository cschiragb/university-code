import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	
	private Book b1;
	private Book b2;
	private Book b3;
	
	@Before
	public void setup() {
		b1 = new Book("Harry Potter and the Order of Phoenix", 2003, "978-0-74-75694-04");
		b2 = new Book("£ Entrepreneurship £", 2015, "");
        b3 = new Book("Advanced Topics in Java", 2014, "978-1-4302-6620-4");
	}
	
	
	// testing getter for title
	@Test
	public void test1() {
		String expected = "Harry Potter and the Order of Phoenix";
		String actual = b1.getTitle();
		assertEquals(expected, actual);
	}
	
	// testing getter for year
	@Test
	public void test2() {
		int expected = 2003;
		int actual = b1.getYear();
		assertEquals(expected, actual);
	}
	
	// testing getter for ISBN
	@Test
	public void test3() {
		String expected = "978-0-74-75694-04";
		String actual = b1.getIsbn();
		assertEquals(expected, actual);
	}
	
	// testing setter for title
	@Test
	public void test4() {
		b1.setTitle("John Dolby");
		String expected = "John Dolby";
		String actual = b1.getTitle();
		assertEquals(expected, actual);
	}
	
	// testing getter for title
	@Test
	public void test5() {
		String expected = "£ Entrepreneurship £";
		String actual = b2.getTitle();
		assertEquals(expected, actual);
	}
	
	// testing getter for year
	@Test
	public void test6() {
		int expected = 2015;
		int actual = b2.getYear();
		assertEquals(expected, actual);
	}
	
	// testing getter for ISBN
	@Test
	public void test7() {
		String expected = "";
		String actual = b2.getIsbn();
		assertEquals(expected, actual);
	}

    	// testing getter for ISBN
	@Test
	public void test8() {
		String expected = "978-1-4302-6620-4";
		String actual = b3.getIsbn();
		assertEquals(expected, actual);
	}

	// testing setter for title 
	@Test
	public void test9() {
		b2.setTitle("1999");
		String expected = "1999";
		String actual = b2.getTitle();
		assertEquals(expected, actual);
	}

}
