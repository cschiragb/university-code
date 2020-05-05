import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Ex2Tests {
	
	private BankAccount b1;
	private BankAccount b2;
	
	@Before
	public void setup() {
		
		b1 = new BankAccount(1, 100, 20);
		b2 = new BankAccount(2, 568, 87);
		
	}
	
	// testing getter for account number
	@Test
	public void test1() {
		int expected = 1;
		int actual = b1.getAccountNumber();
		assertEquals(expected, actual);
	}

	// testing getter for balance
	@Test
	public void test2() {
		int expected = 80;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing getter for balance
	@Test
	public void test3() {
		int expected = 481;
		int actual = b2.getBalance();
		assertEquals(expected, actual);
	}
	
	// another test for balance getter
	@Test
	public void test4() {
		int expected = 87;
		int actual = b2.getSetupFee();
		assertEquals(expected, actual);
	}

	// testing setter for balance
	@Test
	public void test5() {
		b1.setBalance(1593);
		int expected = 1593;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for balance (0 balance)
	@Test
	public void test6() {
		b1.setBalance(0);
		int expected = 0;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for balance (negative balance)
	@Test
	public void test7() {
		b1 = new BankAccount(1, 20, 50);
		int expected = -30;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for balance 
	@Test
	public void test8() {
		b1 = new BankAccount(1, 0, 50);
		b1.setBalance(1500);
		int expected = 1500;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing balance getter
	@Test
	public void test9() {
		b1 = new BankAccount(1, 50, 50);
		int expected = 0;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}

	// testing construction with negative fee
	@Test
	public void test10() {
		b1 = new BankAccount(1, 20, -50);
		int expected = 70;
		int actual = b1.getBalance();
		assertEquals(expected, actual);
	}
	
    
}
