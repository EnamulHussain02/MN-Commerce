package mn_commerce2;
import java.sql.*;
import java.util.*;
public class MainMethod
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Table1 t1=new Table1(); 
		Table2 t2=new Table2(); 
		Table3 t3=new Table3(); 
		Table4 t4=new Table4(); 
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mn_commerce","root","tiger");  
			Statement stmt=con.createStatement();   
			ResultSet rs = stmt.executeQuery("Show tables");
		    System.out.println("Tables in the current database: ");
		    while(rs.next()) 
		    {
		        System.out.print(rs.getString(1));
		        System.out.println();
		    }
		    System.out.println("Enter the Table Number to Display");
			int number=sc.nextInt();
		
			
			switch (number)
			{
			case 2:
				t1.viewTable(con,"select * from customer_details");
				break ;
			case 4:		
				t2.viewTable(con,"select * from product_details");
				break ;
				
			case 1:
				t4.viewTable(con,"select * from cart");
				break ;
				
			case 3:
				t3.viewTable(con,"select * from orders");
				break ;
				
			} 
			
			}
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
	}
}
