

import java.util.Scanner;

import exception.InvalidUserException;

public class Login {
	String uname;
	String password;
	boolean inputCredentials() throws InvalidUserException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Bank!!!");
		System.out.println("Enter Username: ");
		uname = sc.nextLine();
		System.out.println("Enter Password: ");
		password = sc.nextLine();
		if(uname.equals("planon") && password.equals("planon123")) {
			System.out.println("Login Successfull");
			return true;
		}else {
			throw new InvalidUserException("Invalid Credentials");
		}
	}
}
