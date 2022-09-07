import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bankManagement {
	static Connection con = connection.getConnection();
	public static void AccountOpen(String name,int balance) throws ClassNotFoundException, SQLException {
		try {
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT MAX(ac_no) FROM person");
			int max=0;
			while(result.next()) {
				max = result.getInt("MAX(ac_no)");
			}
			max+=1;
			String query="Insert INTO person(ac_no,Cname,Balance) VALUES("+max +",'"+name+"',"+ balance +")";
			int ct = stmt.executeUpdate(query);
			if(ct>0) {
				System.out.println("Your Account created successfully! your ac no is : "+ max);
			} else {
				System.out.println("There is some error while creating your account,contact support team!!!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		public static void checkBalance(int acno) throws ClassNotFoundException, SQLException {
			try {
				Statement stmt = con.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT Cname,balance FROM person" + " where ac_no= "+acno+"");
				int balanceamt=0;
				String name="";
				while (rset.next()) {
					name=rset.getString("Cname");
				    balanceamt=rset.getInt("balance");
				}
					System.out.println("Customer name : " +name+ " With ac no : "+ acno + " has a current balance : Rs."+balanceamt);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		public static void withdrawal(int acno,int amount) throws ClassNotFoundException, SQLException {
			try {
				Statement stmt = con.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT balance FROM person" + " where ac_no= "+acno+"");
				int balanceamt=0;
				while (rset.next())
				    balanceamt=rset.getInt(1);
				if(balanceamt<amount) {
					System.out.println("You Don't have sufficient balance");
				}else {
						balanceamt-=amount;
						@SuppressWarnings("unused")
						ResultSet rs = stmt.executeQuery("UPDATE person " + "SET balance="+balanceamt+" where ac_no="+acno+"");
						ResultSet rsett = stmt.executeQuery("SELECT Cname ,balance FROM person" + " where ac_no= "+acno+"");
						int updatedamtt=0;
						String name="";
						while(rsett.next()) {
						name=rsett.getString("Cname");
				        updatedamtt = rsett.getInt("balance");
						}
						System.out.println("Customer name : " +name+ " With acc no : "+ acno + " withdrawal amount Rs."+amount+" has a current balance : Rs."+updatedamtt);
					}
				} catch(Exception e) {
					e.printStackTrace();
			}
		}
		public static void deposit(int acno,int amount) throws SQLException, ClassNotFoundException {
			try {
				Statement stmt = con.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT balance FROM person" + " where ac_no= "+acno+"");
				int balanceamt=0;
				while (rset.next())
				    balanceamt=rset.getInt(1);
				balanceamt+=amount;
				@SuppressWarnings("unused")
				ResultSet rs = stmt.executeQuery("UPDATE person " + "SET balance="+balanceamt+" where ac_no="+acno+"");
				ResultSet rsett = stmt.executeQuery("SELECT Cname,balance FROM person" + " where ac_no="+acno+"");
				int updatedamtt=0;
				String name="";
				while(rsett.next()) {
					name=rsett.getString("Cname");
					updatedamtt = rsett.getInt("balance");
				}
				System.out.println("Customer name : " +name+ " With acc no : "+ acno + " Deposited amount Rs."+amount+" has a current balance : Rs."+updatedamtt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}