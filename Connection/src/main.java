import java.sql.SQLException;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		@SuppressWarnings("resource")
		Scanner scn=new Scanner(System.in);
		while(true) {
			//System.out.println("--------------------Menu------------------");
			System.out.println("choose one:");
			System.out.println("1. Open an account");
			System.out.println("2. Check Balance");
			System.out.println("3. Withdrawal");
			System.out.println("4. Deposit");
			System.out.println("5. Exit");
			System.out.println("Enter your option : ");
			int option=scn.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter you name :");
					String name=scn.next();
					System.out.println("Enter the initial amount you want to deposit in your account:");
					int balance=scn.nextInt();	
					bankManagement.AccountOpen(name,balance);
					break;
				case 2:
					System.out.println("Enter you acc no:");
					int ac1=scn.nextInt();
					bankManagement.checkBalance(ac1);
					break;
				case 3:
					System.out.println("Enter you ac no:");
					int ac2=scn.nextInt();
					System.out.println("Enter amount you want to withdrawal from your account:");
					int amount=scn.nextInt();
					bankManagement.withdrawal(ac2,amount);
					break;
				case 4:
					System.out.println("Enter you ac no:");
					int ac3=scn.nextInt();
					System.out.println("Enter amount you want to deposit in your account:");
					int amount1=scn.nextInt();
					bankManagement.deposit(ac3,amount1);
					break;
				case 5:
					System.out.println("Exit successfully.");
					return;
				default:
					System.out.println("try again");
					break;
			}
		}
	}
}
