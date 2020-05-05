/** 
 * The abstract class BankAccountUser creates the generic profile of an internet banking user
 * and implements the interface BankAccountUserInterface for defining such a user.
 * No objects are made in this class due to it being abstract.
 * 
 * We establish three field variables:
 * username 	- is a String of the username for the BankAccountUser
 * password 	- is a String of the password for the BankAccountUser
 * loggedIn 	- is a boolean indicating the login status of the BankAccountUser
 *  
 * @author Chirag Bhatti
 * @version 18/11/2018
 */

public abstract class BankAccountUser implements BankAccountUserInterface {

	private String username;
	private String password;
	private boolean loggedIn;
	
	/** BankAccountUser is a constructor to create an internet banking user
	 * 
	 * @param username is the username to be used at login for an internet banking user as a String
	 * @param password is the password to be used at login for an internet banking user as a String
	 * @param loggedIn is the log in status of the internet banking user as a boolean, and is initialised to false.
	 */
	public BankAccountUser(String username, String password) {
		this.username 	= username;
		this.password	= password;
		this.loggedIn	= false;
	}
	
	/** login is a method specified by the interface.
	 * 
	 * The method provides a log in method by checking firstly if the password provided by the 
	 * user is correct using the passwordCorrect method below.
	 * If correct, the loggedIn status is updated to true, otherwise it remains as false.
	 */
	@Override
	public void login(String password) {
		if (passwordCorrect(password) == true) {
			setLoggedIn(true);
		}
		else setLoggedIn(false);
	}

	/** Logout is a method specified by the interface.
	 * 
	 * The method sets the users logged in status to false when invoked
	 */
	@Override
	public void logout() {
		setLoggedIn(false);
	}
	
	private String getPassword() {
		return password;
	}
	
	/** passwordCorrect is a method specified by the interface
	 * 
	 * The method checks the password provided by the internet banking user matches the
	 * password stored for them in the field variable password
	 * 
	 * @param password is the password provided by the internet banking user
	 * @return boolean (true or false) depending on if the supplied password is correct
	 */
	@Override
	public boolean passwordCorrect(String password) {
		return this.password.equals(password);
	}
	
	/** setPassword is a method specified by the interface
	 * 
	 * Sets the password for an internet banking user
	 * @param password
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
		
	/** getLoggedIn is a method specified by the interface
	 * 
	 * @return the logged in status of the internet banking user as a boolean
	 */
	@Override 
	public boolean getLoggedIn() {
		return loggedIn;
	}
	
	/** setLogged in a method specified by the interface
	 * 
	 * Sets the loggedIn status of an internet banking user
	 * @param loggedIn
	 */
	@Override
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn 	= loggedIn;
	}
}

