import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Ex1Tests {
	
	private Book b1;
	private Book b2;
	private Book b3;
	
	@Before
	public void setup() {
		b1 = new Book("War and Peace", 1869, "978-3-16-148410-0");
		b2 = new Book("The Picture of Dorian Gray", 1890, "978-1-4028-9462-6");
                b3 = new Book("Java - How to Program", 2016, "");
	}
	
	// testing getter for title
	@Test
	public void test1() {
		String expected = "War and Peace";
		String actual = b1.getTitle();
		assertEquals(expected, actual);
	}
	
	// testing getter for year
	@Test
	public void test2() {
		int expected = 1869;
		int actual = b1.getYear();
		assertEquals(expected, actual);
	}
	
	// testing getter for ISBN
	@Test
	public void test3() {
		String expected = "978-3-16-148410-0";
		String actual = b1.getIsbn();
		assertEquals(expected, actual);
	}
	
	// testing setter for title
	@Test
	public void test4() {
		b1.setTitle("Anna Karenina");
		String expected = "Anna Karenina";
		String actual = b1.getTitle();
		assertEquals(expected, actual);
	}
	
	// testing getter for title
	@Test
	public void test5() {
		String expected = "The Picture of Dorian Gray";
		String actual = b2.getTitle();
		assertEquals(expected, actual);
	}
	
	// testing getter for year
	@Test
	public void test6() {
		int expected = 1890;
		int actual = b2.getYear();
		assertEquals(expected, actual);
	}
	
	// testing getter for ISBN
	@Test
	public void test7() {
		String expected = "978-1-4028-9462-6";
		String actual = b2.getIsbn();
		assertEquals(expected, actual);
	}

    	// testing getter for ISBN
	@Test
	public void test8() {
		String expected = "";
		String actual = b3.getIsbn();
		assertEquals(expected, actual);
	}

	// testing setter for title 
	@Test
	public void test9() {
		b2.setTitle("1984");
		String expected = "1984";
		String actual = b2.getTitle();
		assertEquals(expected, actual);
	}

}
