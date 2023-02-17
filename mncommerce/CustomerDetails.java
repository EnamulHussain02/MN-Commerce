package com.mncommerce;

import java.sql.*;
import java.util.Scanner;

public class CustomerDetails implements Executable 
{
	public void viewTable() throws SQLException 
	{
		System.out.println("sivanath");
		String query = null;
		Connection con=MainClass.getConnection();
		try (Statement stmt = con.createStatement()) 
		{
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) 
			{
				System.out.println("Customer Table");
				System.out.println("Customer Id: " + rs.getInt(1) + "\nCustomer Name: " + rs.getString(2)
						+ "\nCustomer Number: " + rs.getLong(3) + "\nCustomer Address: " + rs.getString(4) + "\n\n");
			}
			con.close();
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}

	}

	public void insertCustomer() throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		CustomerDetails cobj=new CustomerDetails();
		MainClass mobj=new MainClass();
		PreparedStatement preparedStatement = null;
		System.out.println("You are registering into MN -  commerce");
		Connection con=MainClass.getConnection();
		System.out.println("Enter your number: ");
		long cNumber = sc.nextLong();
		sc.nextLine();
		boolean result=cobj.checkUser( cNumber);
		if(result==false)
		{
			
			System.out.print("Enter your name: ");
		
			String cName = sc.nextLine();
		
			System.out.println("Enter your address: ");
			String cAddress = sc.nextLine();
			
			String query = "insert into customer_details" + "(customer_name, customer_number, customer_address)"
					+ "values(?,?,?)";
			try
			{
						preparedStatement = con.prepareStatement(query);
						preparedStatement.setString(1, cName);
						preparedStatement.setLong(2, cNumber);
						preparedStatement.setString(3, cAddress);
	
						preparedStatement.executeUpdate();
	
						preparedStatement.close();
						System.out.println("You have Registred Successfully.");
						mobj.showMenu();
						
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("You are an registred user ");
			mobj.showMenu();
		}
		
	}
	
	public boolean checkUser( long phNumber) 
	{
		CustomerDetails cObj = new CustomerDetails();
		MainClass mobj=new MainClass();
		ResultSet rs;
		boolean has_results=false;
		Connection con=MainClass.getConnection();
		try (Statement stmt = con.createStatement())
		{
			rs = stmt.executeQuery("select customer_number from customer_details where customer_number='" + phNumber + "'");
			has_results = rs.next();
			
			
		}
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return has_results;

	}
}