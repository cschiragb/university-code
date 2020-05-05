/** 
 * The class BankAccountAdministrator is a subclass of BankAccountUser and utilises the interface 
 * BankAccountAdministratorInterface, to create the profile of an administrator who can oversee
 * user accounts (BankAccountUsers) for internet banking.
 * 
 * * We inherit two field variables from the BankAccountUser super class:
 * username 		- is the username in this case of the administrator for internet banking
 * password 		- is the password in this case of the administrator for internet banking
 * 
 * We establish one additional field variable:
 * bankAccountUsers - is the list of all internet banking users in an array list of type BankAccountUser (the superclass)
 * 					  the administrator maybe resposible for.
 * 
 * @author Chirag Bhatti
 * @version 18/11/2018
 */

import java.util.ArrayList;

public class BankAccountAdministrator extends BankAccountUser implements BankAccountAdministratorInterface {
	private ArrayList <BankAccountUser> bankAccountUsers;
	
	/** BankAccountAdministrator is a constructor to create the profile of an administrator
	 * 
	 * @param username is the username for the administrator as String from the superclass
	 * @param password is the password for the administrator as String from the superclass
	 * @param bankAccountUsers is an array list of internet banking users of type BankAccountUser under the remit of the administrator
	 */
	public BankAccountAdministrator(String username, String password) {
		super(username, password);
		this.bankAccountUsers = new ArrayList <BankAccountUser>();
	}
	
	/** login is a method specified by the interface and also exists in the superclass.
	 * 
	 * This method calls the superclass login method, as the administrator does not 
	 * need a unique login method.
	 * 
	 * @param password is the password used by the administrator to login
	 * 
	 */
	@Override
	public void login(String password) {
		super.login(password);
		/* The login method above could also have been left out completely, as this would have meant the superclass method would be
		 * called instead. However this has been left in for completeness, due to the interface defining the need of a login method
		 * for this class.
		 */
	}
	
	/** addUser is a method specified by the interface
	 * 
	 * The method checks the administrator is first logged in, and then adds a BankAccountUser (superclass)
	 * to the array list that may additionally fall under the administrator's remit.
	 * 
	 * @param user is the user of internet banking of type BankAccountUser (the superclass)
	 */
	@Override
	public void addUser(BankAccountUser user) {
		if (super.getLoggedIn() == true) {
			bankAccountUsers.add(user);
		}
	}

	/** resetAccount is a method specified by the interface
	 * 
	 * The method first checks the administrator is logged in. 
	 * If so, it casts a BankAccountUser as a standard user if the user is an instance of a standard user.
	 * If so then the method will change / reset the password of an internet banking user as well as reset the number of login attempts
	 * they have had, meaning the administrator has released the locked account.
	 * 
	 * @param bankAccountUser is the bank account user of internet banking in question
	 * @param password is the new password for the bank account user in question (which can be considered of type BankAccountStandardUser i.e. the subclass) 
	 */
	@Override
	public void resetAccount(BankAccountUser bankAccountUser, String password) {
		if (super.getLoggedIn() == true) {
				if (bankAccountUser instanceof BankAccountStandardUser == true) {
					BankAccountStandardUser standard = (BankAccountStandardUser) bankAccountUser;
					standard.setPassword(password);
					standard.resetLoginAttempts();
				}
		}
	}
	
}