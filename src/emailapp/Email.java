package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String company;
	private String email;
	private int mailBoxCapacity;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix ="leilacompany.com";
	//Constructor to receive first and last name
	public Email(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		
		//call a method asking for the department-return the department
		this.department=setDepartment();
		System.out.println("Department:"+ this.department);
		
		
		//call a method that returns a random password
		this.password=randomPassword(defaultPasswordLength);
		System.out.println("Your password  is:" + this.password);
		
		//combine elements to generate email
		
		email=firstName.toLowerCase()+"."+lastName.toLowerCase() + "@"+	department +"." + companySuffix;
		System.out.println("Your email is :" + email);
	}
	
	
	//Ask for the department 

	private String setDepartment() {
		System.out.println("Department CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
		Scanner in=new Scanner(System.in);
		int depChoice=in.nextInt();
		if(depChoice==1) {return "Sales";}
		else if(depChoice==2) {return "dev";}
		else if(depChoice==3) {return "acct";}
		else {return " ";}
		
	}
	
	//generate a random password
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password=new char[length];
		for (int i=0;i<length;i++) {
			int rand=(int)(Math.random() * passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//set the mailbox capacity
	//set the alternate email
	//Change the password
}
