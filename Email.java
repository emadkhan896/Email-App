package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private int mailboxCapacity = 500;
	private int defaultpasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	// constructor to receive the first Name and Last Name
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created: " + this.firstName + " " + this.lastName);
		
		// Call a method asking for the department - return the department 
		this.department = setDepartment();
		//System.out.println("Department: " +this.department);
		
		// Call a method that a returns a random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your password is: " +this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." +lastName.toLowerCase() + "@" + department + "." +companySuffix;
		//System.out.println("Your email is: " +email);
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.print("New Worker:" +firstName + "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		if(depChoice == 1) {return "sales";}
		else if(depChoice == 2) {return "dev";}
		else if(depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	
	
	// Generate a random password
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
 		}
		return new String(password);
	}
	
	// Set the mailbox Capacity
	public void setMailboxCapacity(int Capacity) {
		this.mailboxCapacity = Capacity;
		
	}
	
	// set the alternate email
	public void setAlternateEmail(String altEMail) {
		this.alternateEmail = altEMail;
	}
	
	// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getChangepassword() {return password;} 
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				" \nCOMPANY EMAIL: " + email +
				" \nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
}
