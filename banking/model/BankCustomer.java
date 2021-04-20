
package model;

import java.util.Scanner;

import exception.InvalidAccountNumberException;


public class BankCustomer {
	private long accno;
	private String cname;
	private String acctype;
	private double bal;
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		if(bal>1000)
			this.bal=bal;
		else {
			System.out.println("Can not Create Account due to Insufficient Balance....");
			System.exit(0);
		}
	}
	public void setDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nCreating a new Account....");
		System.out.println("Enter Account number:");
		setAccno(Long.parseLong(sc.nextLine()));
		System.out.println("Enter Account holder Name: ");
		setCname(sc.nextLine());
		System.out.println("Enter Account type");
		setAcctype(sc.nextLine());
		System.out.println("Enter Balance: ");
		setBal(Double.parseDouble(sc.nextLine()));
		System.out.println("Account Created Successfully....");
	}
	public void printDetails() {
		System.out.println("\nBank Account Details:");
		System.out.println("Account number: "+getAccno());
		System.out.println("Account holder: "+getCname());
		System.out.println("Account type: "+getAcctype());
		System.out.println("Balance: "+getBal());
	}
	public boolean verifyAccNum(long accnum) throws InvalidAccountNumberException {
		if(accnum==getAccno()) {
			return true;
		}else {
			throw new InvalidAccountNumberException("Invalid Account number");
		}
	}
	public String toString() {
		return "BankCustomer: accno=" + accno + ", cname=" + cname + ", acctype=" + acctype + ", bal=" + bal;
	}
	
}
