package mn_commerce2;
import java.sql.*;
public class Table3 extends Table2
{
	public void viewTable(Connection con,String query1) throws SQLException
	 {
		    this.query =query1 ;
		    try (Statement stmt = con.createStatement())
		    {
		      rs = stmt.executeQuery(query);
		      while (rs.next()) 
		      {
		    	  System.out.println("Order Table");
				 System.out.println("Order Id: "+rs.getInt(1)+"\nProduct Id: "+rs.getInt(2)+"\nCustomer Id "+rs.getInt(3)+"\nTotal: "+rs.getDouble(4)+"\nPayment Via: "+rs.getString(5)+"\nPayment Date: "+rs.getString(6)+"\nPaymentStatus: "+rs.getString(7)+"\nDelivery Status: "+rs.getString(8)+"\n\n");  
				 
		      }
		      con.close();
		    }
		      catch (SQLException e)
		      {
				System.out.println(e);
		      }
		    
		  }
}
