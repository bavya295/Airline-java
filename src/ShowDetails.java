import java.sql.*;
public class ShowDetails extends DBoperations{
    public void showAllDetails(String query)
    {
        try{
           ps=connect.prepareStatement(query);
           rs=ps.executeQuery();
           while(rs.next())
           {
            System.out.println("Flight_ID  |  Name  |   Source   |    Destination  |   Arrival  |    Depature  |  Duration");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println(rs.getString(1)+"  |  "+rs.getString(2)+"  |   "+rs.getString(3)+"    |      "+rs.getString(4)+"   |  "+rs.getString(5)+"   |   "+rs.getString(6)+"  |  "+rs.getString(7));
           }
        }
        catch(Exception e)
        {
            System.out.println("NO FLIGHT AVAILABLE");
        }
    }
    public void showFilteredResult(String query1, String filter)
    {
        try{
            ps=connect.prepareStatement(query1);
            ps.setString(1, filter);
            rs=ps.executeQuery();
            while(rs.next())
            {
             System.out.println("Flight_ID  |  Name  |   Source   |    Destination  |   Arrival  |    Depature  |  Duration");
             System.out.println("----------------------------------------------------------------------------------------------");
             System.out.println(rs.getString(1)+"  |  "+rs.getString(2)+"  |   "+rs.getString(3)+"    |      "+rs.getString(4)+"   |  "+rs.getString(5)+"   |   "+rs.getString(6)+"  |  "+rs.getString(7));
            }
         }
         catch(Exception e)
         {
             System.out.println("NO FLIGHT AVAILABLE");
         } 
    }
}
