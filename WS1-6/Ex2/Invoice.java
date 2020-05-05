/** 
 * Invoice is a class for the creation of an invoice and implements the interface Measurable for
 * obtaining values that are measurable and of type double.
 * 
 * We define three field variables to this class:
 * 
 * accountNumber - is a String of the account number associated with the invoice
 * sortCode - is a String of the account sort code associated with the invoice
 * amount - is a double value of the amount that the invoice is subject to
 * 
 * @author Chirag Bhatti
 * @version 18/11/2018
 */


public class Invoice implements Measurable {
	private String accountNumber;
	private String sortCode;
	private double amount;
	
	/** Invoice is a constructor to create the outline of an invoice
	 * 
	 * @param accountNumber is the account number associated with the invoice of type String
	 * @param sortCode is the account sort code associated with the invoice of type String
	 * @param amount is the amount of money the invoice is subject to of type double
	 */
	public Invoice (String accountNumber, String sortCode, double amount) {
		this.accountNumber 	= accountNumber;
		this.sortCode 		= sortCode;
		this.amount			= amount;
	}
	
	/** 
	 * 
	 * @return the account number on the invoice as String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * 
	 * @return the account sort code on the invoice as String
	 */
	public String getSortCode() {
		return sortCode;
	}
	
	/**
	 * 
	 * @return the amount the invoice is subject to as double
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * getValue is a getter that is specified by the Measurable interface that is being overridden
	 * @return the amount on the invoice of type double by calling the getAmount() method
	 */
	@Override
	public double getValue() {
		return getAmount();
	}
	
	/**
	 * Sets the account number for the invoice
	 * @param accountNumber
	 */
	public void setAccounNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Sets the sort code for the invoice
	 * @param sortCode
	 */
	public void setSortCode (String sortCode) {
		this.sortCode = sortCode;
	}
	
	/**
	 * Sets the amount for the invoice
	 * @param amount
	 */
	public void setAmount (double amount) {
		this.amount = amount; 
	}
}
