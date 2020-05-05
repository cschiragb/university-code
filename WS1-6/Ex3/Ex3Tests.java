import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * See additional tests 7 - 10 at the bottom
 * @author Chirag Bhatti
 */
public class Ex3Tests {

	private BankAccountAdministrator itdepartment, techsupport;
	private Customer customerJohn, customerMary, customerTony;
	private BankAccount bankAccountJohn, bankAccountMary, bankAccountTony;
	private BankAccountStandardUser john, mary, tony;

	@Before
	public void setUp() {
		itdepartment = new BankAccountAdministrator("Trevor", "oreganoUser");
		techsupport = new BankAccountAdministrator("Katie", "basilUser");
		customerJohn = new Customer("John", "m", "Bham", "0121");
		customerMary = new Customer("Mary", "f", "Bham", "0121");
		customerTony = new Customer("Tony", "x", "Bham", "0121");
		bankAccountJohn = new BankAccount(customerJohn, "kelloggs");
		bankAccountMary = new BankAccount(customerMary, "cheerios");
		bankAccountTony = new BankAccount(customerTony, "shreddies");
		john = new BankAccountStandardUser("John", "kelloggsUser", bankAccountJohn);
		mary = new BankAccountStandardUser("Mary", "cheeriosUser", bankAccountMary);
		tony = new BankAccountStandardUser("Tony", "shreddiesUser", bankAccountTony);
	}
		
	// John logs in successfully and transfers
	// some money to Mary's bank account.
	@Test
	public void test1() {
		john.login("kelloggsUser");

		// expected number of failed login attempts is 0
		int expectedLoginAttempts = 0;
		int actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(john.getLoggedIn());

                // transfer fails because of insufficient funds
		john.transferMoney(bankAccountMary, 150, "kelloggs");

		double expectedBalance = 100;
		double actualBalance = mary.getBankAccount().getBalance();

		assertEquals(expectedBalance, actualBalance, 0.00001);

                // transfer succeeds
		john.transferMoney(bankAccountMary, 10, "kelloggs");
		double expectedBalanceJohn = 90;
		double actualBalanceJohn = john.getBankAccount().getBalance();
		assertEquals(expectedBalanceJohn, actualBalanceJohn, 0.00001);
		double expectedBalanceMary = 110;
		double actualBalanceMary = mary.getBankAccount().getBalance();
		assertEquals(expectedBalanceMary, actualBalanceMary, 0.00001);
	
	}

	// Mary makes 1 failed login attempt,
	// logs in using the correct password
	// and logs out. Then Mary tries to transfer some
	// money to Tony's bank account but forgets the password
	@Test
	public void test2() {
		mary.login("cheeriosuser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = mary.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(mary.getLoggedIn());

		mary.login("cheeriosUser");
		expectedLoginAttempts = 0;
		actualLoginAttempts = mary.getLoginAttempts();
		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(mary.getLoggedIn());

		mary.logout();
		assertFalse(mary.getLoggedIn());

		mary.setPassword("linseeedUser");
		mary.transferMoney(bankAccountTony, 20, "cheerios");

		double expectedBalance = 100;
		double actualBalance = tony.getBankAccount().getBalance();

		assertEquals(expectedBalance, actualBalance, 0.00001);

	}

	// Tony makes 2 failed login attempts and
	// then logs in using the correct password
	@Test
	public void test3() {

		// First failed login attempt
		tony.login("kornUser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = tony.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(tony.getLoggedIn());

		// Second failed login attempt
		tony.login("shreddiesuser");
		expectedLoginAttempts = 2;
		actualLoginAttempts = tony.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(tony.getLoggedIn());

		// Third attempt is successful
		tony.login("shreddiesUser");
		expectedLoginAttempts = 0;
		actualLoginAttempts = tony.getLoginAttempts();
		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(tony.getLoggedIn());

	}

	// John makes 4 failed login attempts and
	// calls admin. Admin logs in successfully
	// and then resets John's password and John's login attempts to 0.
	@Test
	public void test4() {

		// First failed login attempt
		john.login("wehatUser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(john.getLoggedIn());

		// Second failed login attempt
		john.login("kelloggsuser");
		expectedLoginAttempts = 2;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Third failed login attempt
		john.login("kelloggsuser");
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Fourth failed login attempt
		john.login("kelloggsuser");
		// Failed login attempts remain 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Administrator resets john's password
		itdepartment.login("oreganoUser");
		itdepartment.addUser(john);
		itdepartment.resetAccount(john, "kelloggsUser1");

		// John logs in successfully using the
		// new password
		john.login("kelloggsUser1");

		expectedLoginAttempts = 0;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(john.getLoggedIn());

	}

	// John makes 4 failed login attempts and
	// calls admin. Admin forgets to log in and tries
	// to reset John's password.
	@Test
	public void test5() {

		// First failed login attempt
		john.login("wehatUser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(john.getLoggedIn());

		// Second failed login attempt
		john.login("kelloggsuser");
		expectedLoginAttempts = 2;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Third failed login attempt
		john.login("kelloggsuser");
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Fourth failed login attempt
		john.login("kelloggsuser");
		// Failed login attempts remain 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Administrator tries to reset john's password
		// without logging in
		itdepartment.addUser(john);
		itdepartment.resetAccount(john, "kelloggsUser1");

		// John tries to log in again
		john.login("kelloggsUser1");

		// login attempts still 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());
	}

	// John makes 4 failed login attempts and
	// calls admin. Admin calls in techsupport
	// to reset John's password.
    	@Test
	public void test6() {

		// First failed login attempt
		john.login("wehatUser");

		int expectedLoginAttempts = 1;
		int actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);

		assertFalse(john.getLoggedIn());

		// Second failed login attempt
		john.login("kelloggsuser");
		expectedLoginAttempts = 2;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Third failed login attempt
		john.login("kelloggsuser");
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Fourth failed login attempt
		john.login("kelloggsuser");
		// Failed login attempts remain 3
		expectedLoginAttempts = 3;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertFalse(john.getLoggedIn());

		// Administrator resets john's password
		techsupport.login("basilUser");
		techsupport.addUser(john);
		techsupport.resetAccount(john, "kelloggsUser1");

		// John logs in successfully using the
		// new password
		john.login("kelloggsUser1");

		expectedLoginAttempts = 0;
		actualLoginAttempts = john.getLoginAttempts();

		assertEquals(expectedLoginAttempts, actualLoginAttempts);
		assertTrue(john.getLoggedIn());

		john.logout();
		assertFalse(john.getLoggedIn());
	}
    	
	// Mary supposedly logs in successfully, is on her account and then logs out. But she has actually been hacked.
	// The itdepartment decide to lock Mary's internet banking due to suspicious activity. 
	// Mary herself actually tries to login later on but she finds she can't as her account has been locked by the it department administrator.
	@Test
	public void test7() {
		
		mary.login("cheeriosUser");
		assertTrue(mary.getLoggedIn());
		mary.logout();
		assertFalse(mary.getLoggedIn());
		
		itdepartment.login("oreganoUser");
		mary.setLoginAttempts(3);
		mary.login("cheeriosUser");
		
		assertFalse(mary.getLoggedIn());
	}
	
	// Mary gets her password changed by techsupport and she tries to log back in to her account.
	// She manages to gain control back of her account successfully and logs in.
	@Test
	public void test8() {
		
		techsupport.login("basilUser");
		techsupport.addUser(mary);
		techsupport.resetAccount(mary, "notsocheeriosUser1");
		
		mary.login("notsocheeriosUser1");
		assertTrue(mary.getLoggedIn());
		
	}
	
	// Techsupport forget their password and so they ask the itdepartment to reset it for them,
	// but techsupport are not a type of standard user and so the itdepartment cannot reset it, and will need to look into it.
	// Hence techsupport are still not able to login even after a supposed password reset attempt by the it department.
	@Test
	public void test9() {
		
		techsupport.login("basilicoUser");
		assertFalse(techsupport.getLoggedIn());
		
		itdepartment.addUser(techsupport);
		itdepartment.resetAccount(techsupport, "parsleyUser");
		
		techsupport.login("parsleyUser");
		assertFalse(techsupport.getLoggedIn());
	}
	
	// John logins because he gets a notification of a monetary gift from Mary, which he'd like to accept.
	// This works as a negative transfer amount under John's account to Mary
	// This could be deemed a flaw in the design of the system but it is possible
	// John gains £10 into his account while Mary's balance drops by £10, by John doing a negative transfer.
	@Test
	public void test10() {
		
		john.login("kelloggsUser");
		assertTrue(john.getLoggedIn());

                // transfer succeeds
		john.transferMoney(bankAccountMary, -10, "kelloggs");
		double expectedBalanceJohn = 110;
		double actualBalanceJohn = john.getBankAccount().getBalance();
		assertEquals(expectedBalanceJohn, actualBalanceJohn, 0.00001);
		double expectedBalanceMary = 90;
		double actualBalanceMary = mary.getBankAccount().getBalance();
		assertEquals(expectedBalanceMary, actualBalanceMary, 0.00001);
	
	}
    
}
