import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Shop{
	static void Insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			PreparedStatement stmt = con.prepareStatement("insert into shopitems values(?, ?, ?, ?)");

			Scanner sc = new Scanner(System.in);

			System.out.print("Enter item Id ");
			int item_id = sc.nextInt();

			System.out.print("Enter item name ");
			String iten_name = sc.next();

			System.out.print("Enter price ");
			int item_price = sc.nextInt();

			System.out.print("Enter item quantity");
			int item_quantity = sc.nextInt();


			stmt.setInt(1, item_id);
			stmt.setString(2, iten_name);
			stmt.setInt(3, item_price);
			stmt.setInt(4, item_quantity);


			System.out.println("Item Added To Store ");
			stmt.execute();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	static void Update() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			PreparedStatement stmt = con.prepareStatement("Update shopitems set item_price= ? where item_id= ? ");
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter item Id ");
			int item_id = sc.nextInt();

			System.out.print("Enter item price ");
			int item_price = sc.nextInt();

			stmt.setInt(1, item_price);
			stmt.setInt(2, item_id);

			stmt.execute();
			con.close();
			System.out.println("Item updated ");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void Delete() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			PreparedStatement stmt = con.prepareStatement("Delete from shopitems where item_id= ?");
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter item Id ");
			int item_id = sc.nextInt();

			stmt.setInt(1, item_id);

			System.out.println("Do you really want to delete  YES/NO");
			String ch = sc.next();
			if (ch.equalsIgnoreCase("yes")) {
				stmt.execute();
				System.out.println(" Item deleted ");
			} else {
				System.out.println(" item deletion canceled ");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static void Display() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from shopitems");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + ":" + rs.getString(2) + " : " + rs.getInt(3) + " : " + rs.getInt(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class JDBCshop {
	public static void main(String args[]) {
		int ch1;
		do {
			System.out.println("================ ABC general stores ================");
			System.out.println("1.Add the Shop item");
			System.out.println("2.Update the item");
			System.out.println("3.Delete the item");
			System.out.println("4.Display the all items");
			System.out.println("5.Exit");
			System.out.println("--------------------------------");
			System.out.println("Enter your Choice ");

			Scanner sc1 = new Scanner(System.in);
			ch1 = sc1.nextInt();

			if (ch1 == 1) {
				Shop.Insert();
				
			}
			if (ch1 == 2) {
				Shop.Update();
				
			}
			if (ch1 == 3) {
				Shop.Delete();
				
			}
			if (ch1 == 4) {
				Shop.Display();
			
			}
			
		} while (ch1 != 5);
		System.out.println("=============== Application Closed ==============");
	}
	
}