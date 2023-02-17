package com.mncommerce;

import java.sql.*;
import java.util.*;

public class MainClass
{
	public static Connection getConnection(){
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mn_commerce", "root", "tiger");
			
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return conn;
	}	
	
	public static void showMenu()
	{
		Scanner sc = new Scanner(System.in);
		Orders obj=new Orders();		
		CustomerDetails cObj = new CustomerDetails();
		ProductDetails p = new ProductDetails();
		int option;
		System.out.println("Select one of the options given below\n");
		System.out.println("1. Register into MN Commerce");
		System.out.println("2. View the List of Products available");
		System.out.println("3. Insert a new product");
		System.out.println("4. View Your Order History");
		option = sc.nextInt();
		try 
		{
			switch (option) 
			{
				case 1:
					cObj.insertCustomer();
					break;
				case 2:
					p.viewTable();
					break;
				case 3:
					p.insertProducts();
					break;
				case 4:
					obj.viewOrders2();
					break ;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to MN Commerce\n");
		showMenu();
		
	}
}
