/** 
 * BankAccount is a class for a Bank Account consisting of
 * an account number, its balance and the setup fee.
 *  
 * We establish three field variables:
 * accountNumber, an int to uniquely find a bank account
 * balance , an int for the amount of money in the account
 * setupFee, an int for the cost of setting up the account
 *  
 * @author Chirag Bhatti
 * @version 20/10/2018
 */

public class BankAccount {
	private int accountNumber;
	private int balance;
	private int setupFee;
	
	/** 
	 * BankAccount is a constructor for the setup of a bank account created from:
	 * 
	 * @param accountNumber is the account number as int
	 * @param initialDeposit is the initial money paid in to the account as int
	 * @param setupFee is the cost to the customer for setting up the account as int
	 * The balance is calculated in the constructor as a function of the intialDeposit and setupFee parameters
	 */	
	
	public BankAccount (int accountNumber, int initialDeposit, int setupFee) {
		this.accountNumber 	= accountNumber;
		this.balance 		= initialDeposit - setupFee;
		this.setupFee 		= setupFee;
	}
	
	/*
	 * Getters to obtain BankAccount details
	 */
	
	/** 
	 * @return the account number of a BankAccount as int
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	
	/** 
	 * @return the balance of a BankAccount as int
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * @return the setupFee of a BankAccount as int
	 */
	public int getSetupFee() {
		return setupFee;
	}
	
	/* 
	 * Setters to set the BankAccount details
	 * This problem only requires a setter for the balance
	 */
	
	/**
	 * Sets the bank account balance
	 * @param balance
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	/**
	 * Defines how to print a Bank Account's details
	 * @return the print type of an account
	 */
	public String toString() {
		return "Account Number: " + accountNumber + " \u007c" + " Account balance: " + "\u00A3" + balance;
	}
}