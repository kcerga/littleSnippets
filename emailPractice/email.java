package emailPractice;

import java.util.Scanner;

public class email {
	
	private String gname;
	private String surname;
	private String email;
	private String department;
	private String password;
	private String newPass;
	private String altEmail;
	private int depNumber;
	private int decision;
	Scanner reader = new Scanner(System.in);
	
	/** Constructor **/
	public email(String gname, String surname) {
		
		this.gname = gname;
		this.surname = surname;
		
		//Asks user to choose a department code number, and saves it to a variable
		System.out.println("Creating a new email address for " + gname + " " + surname);
		System.out.println("Choose a department:" +
							"\n(1) Storage "
							+ "\n(2) Accounting"
							+ "\n(3) Economics"
							+ "\n(4) Development");
		depNumber = reader.nextInt();
		reader.nextLine();
		
		//Calls methods to set department and to make a new password
		setDepartment();
	
		this.password = randomPassword(10);
		
		//Calls simple methods to get alternative email, set the email address
		setAltEmail();
		setEmail();
		
		//Asks user if they want to change their password 
		System.out.println("Do you want to set your own new password or use the created random password? "
				+ "\n 1 = Create new password"
				+ "\n 2 = Continue with existing password");
		decision = reader.nextInt();
		reader.nextLine();
			if (decision == 1) {
				newPassword();
			}
			else if (decision == 2) {
				System.out.println("Password is set to created random password.");
			}
			else {
				System.out.println("Faulty choice. Password not changed.");
			}
		
	}
	
	//Method to set the department based on user choice
	private void setDepartment() {
		switch(depNumber) {
		case 1: { department = "Storage"; }
			break;
		case 2: {department = "Accounting"; }
			break;
		case 3: {department = "Economics"; }
			break;
		case 4: {department = "Development"; }
			break;
		default:{department = "";}
			break;
		}
	}	
	
	//Method to create random password
	public String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$#";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	
	//Method to change password, with minimum of 8 characters
	private void newPassword() {
		System.out.println("Enter a new password (minimum 8 characters): ");
		newPass = reader.nextLine();
		
		if (newPass.length() < 8) {
			System.out.println("Your password is too short. Please try again.");
			newPassword();
		}
		else {
			this.password = newPass;
			System.out.println("New password set.");
		}		
	}
	
	
	//Alternative email-address
	private void setAltEmail() {
		System.out.println("Please insert your alternative email address: ");
		altEmail = reader.nextLine();
	}
	
	//Creates email address
	private void setEmail() {
		email = gname.toLowerCase() + "." + surname.toLowerCase() + "@" + department.toLowerCase() + "." + "someCompany.com";
	}
	
	 //Shows user information
	public String showInfo() {
		return ("USER: " + surname + " " + gname +
							"\nDEPARTMENT: " + department +
							"\nEMAIL: " + email +
							"\nALTERNATIVE EMAIL: " + altEmail +
							"\nPASSWORD: " + password);
	} 
	

}
