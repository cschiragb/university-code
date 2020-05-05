/** 
 * The class BankAccountStandardUser is a subclass of BankAccountUser and utilises the interface
 * BankAccountStandardUserInterface, to create the profile of a standard user of internet banking
 * on their bank account.
 * 
 * We inherit two field variables from the BankAccountUser super class:
 * username 		- is the username in this case of a standard user of internet banking
 * password 		- is the password in this case of a standard user of internet banking
 * 
 * We establish two additional field variables:
 * bankAccount 		- is the bankaccount associated with the internet banking standard user
 * loginAttempts 	- the number of login attempts made by the bank account standard user
 * 
 * @author Chirag Bhatti
 * @version 18/11/2018
 */
public class BankAccountStandardUser extends BankAccountUser implements BankAccountStandardUserInterface  {
	
	private BankAccount bankAccount;
	private int loginAttempts;
	
	/** BankAccountStandardUser is a constructor to create the profile of a standard user of internet banking
	 * 
	 * @param username is the username of the standard user as String from the superclass
	 * @param password is the password of the standard user as String from the superclass
	 * @param bankAccount is the bankaccount of the standard user as type BankAccount
	 */
	public BankAccountStandardUser(String username, String password, BankAccount bankAccount) {
		super(username, password);
		this.bankAccount 	= bankAccount;
		this.loginAttempts 	= 0;	
	}
	
	/** getBankAccount is a method specified by the interface
	 * 
	 * Getter for the bankaccount
	 * @return bankAccount of the internet banking user
	 */
	@Override
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	
	/** login is a method specified by the interface and also exists in the superclass.
	 * 
	 * This method replaces that written in the superclass as a unique login method is required for the
	 * standard user. 
	 * If the number of login attempts is more than 2 at login, an account locked message is shown.
	 * Otherwise if the number of attempts is 2 or less and the password is correct, the login attempts is reset
	 * to 0 and the user status is set to logged in. 
	 * Otherwise, if the password is incorrect with the number of login attempts at 2 or less, an
	 * additional attempt is counted against the user and they're login status remains false.
	 * 
	 */
	@Override
	public void login(String password) {
		
		if (getLoginAttempts() <= 2 && super.passwordCorrect(password) == true) {
			super.setLoggedIn(true);
			resetLoginAttempts();
		}
		else if (getLoginAttempts() > 2) {
			System.out.println("Account Locked - contact admin for reset");	
		}
		else setLoginAttempts(getLoginAttempts() + 1);
	}
	
	/** getLoginAttempts is a method specified in the interface
	 * 
	 * Getter for the number of login attempts
	 * @return loginAttempts as the number of login attempts as an integer
	 */
	@Override
	public int getLoginAttempts() {
		return loginAttempts;
	}
	
	/** setLoginAttmepts is a method specified in the interface
	 * 
	 * Sets the number of login attempts of the standard user
	 * @param loginAttempts
	 */
	@Override
	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
	
	/** resetLoginAttempts is a method specified in the interface
	 * 
	 * This is a separate method for setting the number of login attempts back to zero
	 * using the setter of login attmepts.
	 */
	@Override
	public void resetLoginAttempts() {
		setLoginAttempts(0);
	}
	
	/** transferMoney is a method specified in the interface
	 * 
	 * This is a separate method to make a money transfer to a different bank account, if
	 * the standard user is logged in to their internet banking, otherwise the transfer
	 * cannot occur. 
	 * The method users the transfer money method as defined in the bankAccount class.
	 * 
	 * @param toAccount which represent the account of the receiver of the transferred money
	 * @param amount which specifies the amount of money to be transferred
	 * @param password of the internet banking standard user that wishes to make the money transfer
	 */
	@Override
	public void transferMoney(BankAccount toAccount, long amount, String password) {
		if (getLoggedIn() == true) {
		bankAccount.transferMoney(toAccount, amount, password);
		}
	}
	
	/** printBalance is a method specified in the interface
	 * 
	 * This is a separate method to print the balance on the account of the standard user
	 * as defined in the bankAccount class.
	 */
	@Override
	public void printBalance() {
		bankAccount.printBalance();
	}
	
	/** printStateement is a method specified in the interface
	 * 
	 * This is a separate method to print the statement for the account of the standard user
	 * as defined in the bankAccount class.
	 */
	@Override
	public void printStatement() {
		bankAccount.printStatement();
	}

}