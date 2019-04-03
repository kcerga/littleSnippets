package emailPractice;
/**
 * 
 * DESC: A simple program that creates email accounts
 * DATE: 09.02.2019
 * @author Wilma C
 *
 */
public class emailApp {

	public static void main(String[] args) {
		
		//Calls to create a new object and sends the user name
		email uusiEmail = new email("John", "Joe");
		
		//Shows email account information
		System.out.println(uusiEmail.showInfo());

	}

}
