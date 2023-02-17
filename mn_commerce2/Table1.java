package mn_commerce2;
import java.sql.*;

public class Table1 
{
	String query;
	ResultSet rs;
	 public void viewTable(Connection con,String query1) throws SQLException 
	 {
		    query=query1;
		    try (Statement stmt = con.createStatement())
		    {
		      rs = stmt.executeQuery(query);
		      while (rs.next()) 
		      {
		    	  System.out.println("Customer Table");
					System.out.println("Customer Id: "+rs.getInt(1)+"\nCustomer Name: "+rs.getString(2)+"\nCustomer Number: "+rs.getLong(3)+"\nCustomer Address: "+rs.getString(4)+"\n\n");  
		      }
		      con.close();
		    }
		      catch (SQLException e)
		      {
				System.out.println(e);
		      }
		    
	 }
}
