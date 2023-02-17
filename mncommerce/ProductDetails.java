package com.mncommerce;

import java.sql.*;
import java.util.*;


public class ProductDetails implements Executable 
{
	public void viewTable() throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		Orders o = new Orders();
		ProductDetails p1 = new ProductDetails();
		Connection con=MainClass.getConnection();
		try (Statement stmt = con.createStatement()) 
		{
			ResultSet rs = stmt.executeQuery("select * from product_details");
			while (rs.next()) 
			{
				System.out.println("Product Id: " + rs.getInt(1) + "\nProduct Name: " + rs.getString(2)
						+ "\nProduct Description: " + rs.getString(3) + "\nProduct Price: " + rs.getInt(4)
						+ "\nProduct Status: " + rs.getString(5) + "\nProduct Code: " + rs.getInt(6)
						+ "\nProduct Quantity: " + rs.getInt(7) + "\n\n");
			}
			System.out.println("Enter the product Id quantity of products to place order");
			int id = sc.nextInt();
			int qan = sc.nextInt();
			o.checkAvailability(id, qan);
		} 
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}
	public static boolean checkProduct(String prdoName)
	{
		Connection con=MainClass.getConnection();
		boolean result=false;
		try(Statement stmt=con.createStatement())
		{
			ResultSet rs= stmt.executeQuery("select product_name from product_details where product_name='"+prdoName+"'");
			 result=rs.next();
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		return  result;
	}

	public void insertProducts() throws SQLException 
	{
		PreparedStatement preparedStatement = null;
		Connection con=MainClass.getConnection();
		Statement stmt=con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("You are inserting a new record in the Product Details table");
		
		System.out.print("Enter the product name: ");
		String pName = sc.nextLine();
		
		System.out.println("Enter the product Description: ");
		String pDescription = sc.nextLine();

		System.out.println("Enter the product Price: ");
		double pPrice = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the Product Status: ");
		String pStatus=sc.nextLine();

		System.out.println("Enter the product Barcode: ");
		int pBarcode = sc.nextInt();

		System.out.println("Enter the product Quantity: ");
		int pQuantity = sc.nextInt();
		
		boolean result=ProductDetails.checkProduct(pName);
		
		if(result)
		{
			try 
			{
				int pid=0;
				int pQan=0;
				ResultSet rs=stmt.executeQuery("select product_detail_id,product_quantity from product_details where product_name='"+pName+"'");
				while(rs.next())
				{
					pid=rs.getInt("product_detail_id");
					pQan=rs.getInt("product_quantity");
					
				}
				pQan=pQan+pQuantity;
				preparedStatement = con.prepareStatement("update product_details set product_name=? , product_description=? , product_price=?, product_status=?, product_barcode=?, product_quantity=? where product_detail_id="+pid+";");
				preparedStatement.setString(1, pName);
				preparedStatement.setString(2, pDescription);
				preparedStatement.setDouble(3, pPrice);
				preparedStatement.setString(4, pStatus);
				preparedStatement.setInt(5, pBarcode);
				preparedStatement.setInt(6, pQan);

				preparedStatement.executeUpdate();

				preparedStatement.close();
				con.close();

				System.out.println("Record inserted successfully.");
				MainClass.showMenu();
			} 
			catch (SQLException e)
			{
				System.out.println(e);
			}
			
		}
		else
		{
			try 
			{
				preparedStatement = con.prepareStatement("insert into product_details"
						+ "(product_name, product_description, product_price,product_status, product_barcode, product_quantity)"
						+ "values(?,?,?,?,?,?)");
				preparedStatement.setString(1, pName);
				preparedStatement.setString(2, pDescription);
				preparedStatement.setDouble(3, pPrice);
				preparedStatement.setString(4, pStatus);
				preparedStatement.setInt(5, pBarcode);
				preparedStatement.setInt(6, pQuantity);
	
				preparedStatement.executeUpdate();
				preparedStatement.close();
				con.close();
	
				System.out.println("Record inserted successfully.");
				MainClass.showMenu();
			} 
			catch (SQLException e)
			{
				System.out.println(e);
			}
		}
	}

	public void alterTable(int id,int qan) 
	{
		PreparedStatement preparedStatement = null;
		Connection con=MainClass.getConnection();
		int qan1=0;
		
		try(Statement stmt = con.createStatement()) 
		{
			ResultSet quantity = stmt.executeQuery("select product_quantity from product_details where product_detail_id='" + id + "'");
			while(quantity.next())
			{
				qan1 = quantity.getInt(1);
			}
			int newQan1=qan1-qan;
			preparedStatement = con.prepareStatement("update product_details set product_quantity =? where product_detail_id=?");
			preparedStatement.setInt(1, newQan1);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
