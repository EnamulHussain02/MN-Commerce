package mn_commerce2;
import java.sql.*;
public class JoinsSql 
{
	public static void main(String[] args) 
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mn_commerce","root","tiger");  
			Statement stmt=con.createStatement();   
			ResultSet rs = stmt.executeQuery("select orders.order_id,product_details.product_name\r\n"
					+ "from orders\r\n"
					+ "inner join product_details\r\n"
					+ "on orders.product_detail_id=product_details.product_detail_id;");
			System.out.println("Executing Inner Joins");
			while(rs.next())
			{
				System.out.println("Order Id: "+rs.getInt(1)+"\tProduct Name: "+rs.getString(2));		   
			}
			ResultSet rs2 = stmt.executeQuery("select customer_detail_id,order_id,product_name,total\r\n"
					+ "from product_details\r\n"
					+ "right outer join orders\r\n"
					+ "on product_details.product_detail_id = orders.product_detail_id\r\n"
					+ "where total>5000;");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Executing right outer Join");
			while(rs2.next())
			{
				System.out.println("Customer Id: "+rs2.getInt(1)+"\tOrder Id: "+rs2.getInt(2)+"\tProduct Name: "+rs2.getString(3)+"\tTotal: "+rs2.getInt(4));		   
			}
			Statement stmt1=con.createStatement();
			ResultSet rs3 = stmt1.executeQuery("select orders.*\r\n"
					+ "from orders\r\n"
					+ "left outer join product_details\r\n"
					+ "on orders.product_detail_id=product_details.product_detail_id;");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Executing left outer Join");
			while(rs3.next())
			{
				System.out.println("Order Id: "+rs3.getInt(1)+"\tCustomer Id: "+rs3.getInt(2)+"\tProduct Id: "+rs3.getInt(3)+"\tNo Of Products: "+rs3.getInt(4)+"Total: "+rs3.getInt(5)+"\tPayment Via: "+rs3.getString(6)+"\tPayment Date: "+rs3.getString(7)+"\tPayment Status: "+rs3.getString(8)+"\tDelivery Status: "+rs3.getString(9));		   
			}
			
		}
		
		catch(Exception e)
		{ 
			System.out.println(e);
		} 
	}
}
