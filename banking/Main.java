

import java.util.Scanner;

import exception.InvalidAccountNumberException;
import exception.InvalidUserException;
import model.BankCustomer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Login l = new Login();
		boolean validate = false;
		do {
			try {
				validate = l.inputCredentials();
			} catch (InvalidUserException e) {
				System.out.println(e.getMessage());
			}
		}while(validate==false);
		BankCustomer bc = new BankCustomer();
		bc.setDetails();		
		do{
			System.out.println("Menu: ");
			System.out.println("1.Transaction");
			System.out.println("2.Print details");
			System.out.println("3.Add new Account");
			System.out.println("4.Delete an Account");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			int ch = Integer.parseInt(sc.nextLine());
			switch(ch) {
				case 1: Transaction tr = new Transaction(bc);
						tr.inputTransactionDetails();
						tr.performTransaction();
						break;
				case 2: try {
							System.out.println("Enter Account number:");
							long acnum = Long.parseLong(sc.nextLine());
								if(bc.verifyAccNum(acnum)) {
									bc.printDetails();
								}
							} catch (InvalidAccountNumberException e) {
								System.out.println(e.getMessage());
							} 
						break;
				case 3: bc = new BankCustomer();
						bc.setDetails();
						break;
				case 4: System.out.println("Enter Account number:");
						long acnum = Long.parseLong(sc.nextLine());
						try {
							if(bc.verifyAccNum(acnum)) {
								bc = null;
								System.out.println("Account Removed Successfully....");
							}
						} catch (InvalidAccountNumberException e) {
							System.out.println(e.getMessage());
						}
						break;
				case 5: System.exit(0);
				default: System.out.println("Enter a valid choice");
			}
		}while(true);
	}
}
