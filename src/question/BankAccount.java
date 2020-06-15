package question;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BankAccount {
	
	Scanner sc = new Scanner(System.in);
	DecimalFormat formatter = new DecimalFormat("###,###");
	int balance;
	
	public static void main(String[] args) {
		
		BankAccount ba = new BankAccount();
		ba.start();
	}
	
	public void menu() {
		System.out.println("===================");
		System.out.println("1. ���� Ȯ��\n2. �ܾ�Ȯ��\n3. �Ա�\n4. ���\n5. ����");
		System.out.println("===================");
	}
	public void start() {
		int i = 0;
		balance = 10000;
		while(i!=5) {
			menu();
			System.out.print("��ȣ �Է�: ");
			i = sc.nextInt();
			if(i == 1)
				System.out.println(i + ".\t" + bank());
			else if(i == 2)	
				System.out.println("�ܾ� : " + formatter.format(balance(balance)));
			else if(i == 3) deposit();
			else if(i == 4) withdraw();
			else if(i == 5) break;
		}
		System.out.println("�����մϴ�.");
	}
	
	public String bank() {
		return "���� 123-456789  (������ : ��ٿ�)";
	}
	
	public int balance(int balance) {
		return balance;
	}
	
	public void deposit() {
		
		System.out.print("�Ա��� �ݾ� : ");
		int money = sc.nextInt();
		ifMoney(money);
		while(ifMoney(money) == false) {
			System.out.print("�ùٸ� �Աݾ��� �Է��ϼ��� : ");
			money = sc.nextInt();
			ifMoney(money);
		}
		
		System.out.println(formatter.format(money) + "�� �Ա��մϴ�.");
		balance = money + balance(balance);
		balance(balance);
	}
	
	public void withdraw() {
		System.out.print("����� �ݾ� : ");
		int money = sc.nextInt();

		withdrawError(money, balance);
		
		while(withdrawError(money, balance) != true) {
			System.out.print("�ܾ��� �����մϴ�. �ٽ� �Է��ϼ��� : ");
			money = sc.nextInt();
			withdrawError(money, balance);
		}
		
		System.out.println(formatter.format(money) + "�� ����մϴ�.");
		balance = balance(balance) - money;
		balance(balance);
	}
	
	public boolean withdrawError(int money, int balance) {
		if(money < balance)
			return true;
		else
			return false;	
	}
	
	public boolean ifMoney(int money) {
		if(money > 0)
			return true;
		else
			return false;	
	}

}



//public void account() {
//	bal = 10000;
//	
//	System.out.println("���� : 123-456789\t(������ : ��ٿ�)");
//	System.out.println("�ܾ� : " + bal);
//	input(bal);
//}
//
//public void input(int bal) {
//	int money;
//	System.out.print("�Ա� �ݾ� : ");
//	money = sc.nextInt();
//	
//	bal += money;
//	System.out.println(money + "�� �Ա��մϴ�.");
//	System.out.println("�ܾ� : " + bal + "��");
//	output(bal);
//}
//
//public void output(int bal) {
//	int money;
//	System.out.print("��� �ݾ� : ");
//	money = sc.nextInt();
//	
//	bal -= money;
//	System.out.println(money + "�� ����մϴ�.");
//	System.out.println("�ܾ� : " + bal + "��");
//}