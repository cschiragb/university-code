import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	
	private BankAccount A1;
	private BankAccount A2;
	
	@Before
	public void setup() {
		
		A1 = new BankAccount(54, 100, 20);
		A2 = new BankAccount(97856, 10, 20);	
	}
	
	// testing getter for account number
	@Test
	public void test1() {
		int expected = 54;
		int actual = A1.getAccountNumber();
		assertEquals(expected, actual);
	}

	// testing getter for balance
	@Test
	public void test2() {
		int expected = 80;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing getter for balance
	@Test
	public void test3() {
		int expected = -10;
		int actual = A2.getBalance();
		assertEquals(expected, actual);
	}
	
	// another test for balance getter
	@Test
	public void test4() {
		int expected = 20;
		int actual = A2.getSetupFee();
		assertEquals(expected, actual);
	}

	// testing setter for balance
	@Test
	public void test5() {
		A1.setBalance(999999);
		int expected = 999999;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for balance (0 balance)
	@Test
	public void test6() {
		A1.setBalance(0);
		int expected = 0;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for balance (negative balance)
	@Test
	public void test7() {
		A1 = new BankAccount(1, -10, -50);
		int expected = 40;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing setter for balance 
	@Test
	public void test8() {
		A1 = new BankAccount(1, 10, 60);
		A1.setBalance(1500);
		int expected = 1500;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}
	
	// testing balance getter
	@Test
	public void test9() {
		A1 = new BankAccount(1, 100, 100);
		int expected = 0;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}

	// testing construction with negative fee
	@Test
	public void test10() {
		A1 = new BankAccount(1, 20, -80);
		int expected = 100;
		int actual = A1.getBalance();
		assertEquals(expected, actual);
	}
	
    
}
