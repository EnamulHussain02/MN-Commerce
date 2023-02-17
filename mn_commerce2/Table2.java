package mn_commerce2;
import java.sql.*;
public class Table2 extends Table1
{
	 public void viewTable(Connection con,String query1) throws SQLException 
	 {
		    query =query1 ;
		    try (Statement stmt = con.createStatement())
		    {
		    	rs = stmt.executeQuery(query);
		      while (rs.next()) 
		      {
		    	  System.out.println("Product Table");
					System.out.println("Product Id: "+rs.getInt(1)+"\nProduct Name: "+rs.getString(2)+"\nProduct Description: "+rs.getString(3)+"\nProduct Price: "+rs.getInt(4)+"\nProduct Status: "+rs.getString(5)+"\nProduct Code: "+rs.getInt(6)+"\nProduct Quantity: "+rs.getInt(7)+"\n\n");  

		      }
			con.close();
		    }
		      catch (SQLException e)
		      {
				System.out.println(e);
		      }
		    
		  }
}
