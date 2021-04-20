

import java.util.Scanner;

import exception.InvalidDepositException;
import exception.InvalidTransactionException;
import exception.InvalidUserException;
import exception.InvalidWithdrawException;
import model.BankCustomer;

public class Transaction {
	BankCustomer b;
	long accnum;
	char ttype;
	double tamt;
	public Transaction(BankCustomer b) {
		this.b = b;
	}
	void inputTransactionDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Transaction Details:");
		do {
			System.out.println("Enter Account number: ");
			accnum = Long.parseLong(sc.nextLine());
			if(accnum!=b.getAccno()) {
				System.out.println("Invalid Account number, Please enter gain:");
				continue;
			}
			break;
		}while(true);
		do{
			System.out.println("Enter type of Transaction:");
			ttype = sc.nextLine().charAt(0);
			if(ttype!='d' && ttype!='w') {
				try {
					throw new InvalidTransactionException("Invalid Transaction Type");
				} catch (InvalidTransactionException e) {
					System.out.println(e.getMessage());
				}
			}else {
				break;
			}
		}while(true);
		System.out.println("Enter Amount: ");
		tamt = Double.parseDouble(sc.nextLine());
	}
	void performTransaction() {
		if(ttype=='w') {
			if(tamt>b.getBal() || tamt<100) {
				try {
					throw new InvalidWithdrawException("Invalid Withdrawal");
				} catch (InvalidWithdrawException e) {
					System.out.println(e.getMessage());
					System.out.println("Enter valid amount: ");
					Scanner sc = new Scanner(System.in);
					tamt = Double.parseDouble(sc.nextLine());
					performTransaction();
				}
			}else {
				b.setBal(b.getBal()-tamt);
				System.out.println("Withdrawal Successfull....");
				if(b.getBal()>1000)
					System.out.println("Updated Account Balance: "+b.getBal());
				else {
					System.out.println("Account has been Removed due to low Balance....");
					b=null;
					System.exit(0);
				}
			}
		}else {
			if(tamt>50000) {
				try {
					throw new InvalidDepositException("Invalid Deposit");
				} catch (InvalidDepositException e) {
					System.out.println(e.getMessage());
					System.out.println("Enter valid amount: ");
					Scanner sc = new Scanner(System.in);
					tamt = Double.parseDouble(sc.nextLine());
					performTransaction();
				}
			}else {
				b.setBal(b.getBal()+tamt);
				System.out.println("Deposit Successfull....");
				System.out.println("Updated Account Balance: "+b.getBal());
			}
		}
		
		
	}
}
