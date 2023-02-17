package com.mncommerce;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Orders implements Executable 
{
	public void viewTable() throws SQLException 
	{
		String query = null;
		Connection con=MainClass.getConnection();
		try (Statement stmt = con.createStatement())
		{
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
			{
				System.out.println("Order Table");
				System.out.println("Order Id: " + rs.getInt(1) + "\nProduct Id: " + rs.getInt(2) + "\nCustomer Id "
						+ rs.getInt(3) + "\nCart Id: " + rs.getString(4) + "\nTotal: " + rs.getDouble(5)
						+ "\nPayment Via: " + rs.getString(6) + "\nPayment Date: " + rs.getString(7)
						+ "\nPaymentStatus: " + rs.getString(8) + "\nDelivery Status: " + rs.getString(9) + "\n\n");

			}
			
		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}

	}

	public void checkAvailability(int pid, int qan1)
	{
		Orders oObj = new Orders();
		ProductDetails pObj = new ProductDetails();
		Connection con=MainClass.getConnection();
		ResultSet quantity;
		int qan = 0;
		try (Statement stmt = con.createStatement())
		{
				quantity = stmt.executeQuery("select product_quantity from product_details where product_detail_id='" + pid + "'");
				while(quantity.next())
				{
					qan = quantity.getInt(1);
				}
			if (qan <= 0) 
			{
				System.out.println("The product is not available" + "\n Plesase select another Product");
				pObj.viewTable();
			} 
			else if (qan < qan1) 
			{
				System.out.println("The product quantity is lesser than you selected" + "\n Please Select lower no of products");
				pObj.viewTable();
			} 
			else 
			{
				oObj.placeOrder(pid, qan1);
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
	}

	public void placeOrder(int pid, int qan1) 
	{
		PreparedStatement preparedStatement = null;
		Orders obj=new Orders();
		ProductDetails pobj=new ProductDetails();
		Connection con=MainClass.getConnection();
		CustomerDetails cObj = new CustomerDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your mobile number to place the order");
		long phNumber = sc.nextLong();
		boolean result=cObj.checkUser( phNumber);
		if(result)
		{
		String cusname=null;
		int cid=0;
		String prodname=null;
		int noofProd=qan1;
		double price=0;
		double prodtotal=0;
		String payMode;
		String paystatus;
		String query = "insert into  orders (customer_name, product_name, no_of_products, total, payment_via, payment_date,customer_detail_id,product_detail_id)"
				+ "values(?,?,?,?,?,?,?,?)";
		try(Statement stmt = con.createStatement()) 
		{
			ResultSet crs=stmt.executeQuery("select customer_name,customer_detail_id from customer_details where customer_number='" + phNumber + "'");
			while(crs.next())
			{
				cusname=crs.getString("customer_name");
				cid=crs.getInt("customer_detail_id");
				
			}
			
			ResultSet prs=stmt.executeQuery("select product_name, product_price from product_details where product_detail_id='" + pid + "'");
			while(prs.next())
			{
				prodname=prs.getString(1);
				price=prs.getDouble(2);
			}
			prodtotal=noofProd*price;
			
			System.out.println("Enter the payment mode");
			sc.nextLine();
			payMode=sc.nextLine();	
			 long millis=System.currentTimeMillis();  
			 
			 java.sql.Date date = new java.sql.Date(millis);
		
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, cusname);
			preparedStatement.setString(2, prodname);
			preparedStatement.setDouble(3, noofProd);
			preparedStatement.setDouble(4, prodtotal);
			preparedStatement.setString(5, payMode);
			preparedStatement.setDate(6, date);
			preparedStatement.setInt(7, cid);
			preparedStatement.setInt(8, pid);
			preparedStatement.executeUpdate();
			System.out.println("Your order has been Placed");
			pobj.alterTable(pid, qan1);
			obj.viewOrder();

		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}
		}
		else
		{
			System.out.println("You are not registred Please Register to continue");
			MainClass.showMenu();
		}
		
	}
	
	public void viewOrder()
	{
		Connection con=MainClass.getConnection();
		try(Statement stmt = con.createStatement()) 
		{
			System.out.println("Order Details:");
			ResultSet rs=stmt.executeQuery("select order_id, customer_name, product_name, no_of_products, total, payment_date from orders where order_id=(select MAX(order_id) from orders)");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------------------------------");  
			System.out.printf("%10s %10s %10s %10s %8s %10s", "    Order Id    |", "    Customer Name    |", "    Product Name    |", "    No Of Products    |", "    Total    |", "    Date    |");  
			System.out.println();  
			System.out.println("-------------------------------------------------------------------------------------------------------------------");  
			while(rs.next())
			{
			System.out.format("%8s %21s %27s %14s %22s %16s",rs.getInt("order_id"),rs.getString("customer_name"),rs.getString("product_name"),rs.getInt("no_of_products"),rs.getInt("total"),rs.getString("payment_date"));  
			}
			System.out.println();  
			System.out.println("-------------------------------------------------------------------------------------------------------------------");  
			System.out.println("\n");
			MainClass.showMenu();
		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public void viewOrders2()
	{
		CustomerDetails cobj=new CustomerDetails();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your mobile number: ");
		long number=sc.nextLong();
		boolean result=cobj.checkUser(number);
		if(result)
		{
		Connection con=MainClass.getConnection();
		try(Statement stmt = con.createStatement()) 
		{
			
			System.out.println("Your Order Details are:");
			ResultSet rs=stmt.executeQuery("select orders.order_id, customer_details.customer_name,product_details.product_name,orders.no_of_products,orders.total,orders.payment_date from orders"
					+ "inner join customer_details on orders.customer_detail_id=customer_details.customer_detail_id"
					+" inner join product_details on orders.product_detail_id=product_details.product_detail_id"
					+" where customer_details.customer_number='"+number+"';");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------------------------------");  
			System.out.printf("%10s %10s %10s %10s %8s %10s", "    Order Id    |", "    Customer Name    |", "    Product Name    |", "    No Of Products    |", "    Total    |", "    Date    |");  
			System.out.println();  
			System.out.println("-------------------------------------------------------------------------------------------------------------------");  
			while(rs.next())
			{
			System.out.format("%8s %25s %27s %14s %18s %16s",rs.getInt("order_id"),rs.getString("customer_name"),rs.getString("product_name"),rs.getInt("no_of_products"),rs.getInt("total"),rs.getString("payment_date")+"\n");  
			System.out.println("-------------------------------------------------------------------------------------------------------------------");  
			}
			System.out.println("\n");  
			MainClass.showMenu();
		
		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}
		}
		else
		{
			System.out.println("You are not an registred user"+"\n");
			MainClass.showMenu();
		}
	}
}