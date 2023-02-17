package mn_commerce2;
import java.sql.*;
public class Table4 extends Table3
{
	 public void viewTable(Connection con,String query1) throws SQLException
	 {
		 this.query = query1;
		 try (Statement stmt = con.createStatement())
		 {
			 rs = stmt.executeQuery(query);
			 while (rs.next()) 
			 {
				 System.out.println("Cart Table");
		    	  System.out.println("Cart Id: "+rs.getInt(1)+"\nCustomer Id: "+rs.getInt(2)+"\nProduct Id: "+rs.getInt(3)+"\nQuantity: "+rs.getInt(4)+"\nOrder Id: "+rs.getInt(5)+"\n\n");  
		    	 
			}
			 con.close();
		 }
		 catch (SQLException e)
		 {
			 System.out.println(e);
		 }
		    
	 }
}
