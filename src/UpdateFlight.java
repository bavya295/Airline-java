import java.sql.*;
public class UpdateFlight extends DBoperations implements Update{
    String query;
    public UpdateFlight(String query)
    {
        this.query=query;
    }
    public void updateDetails(String id , String val)
    {
        try{
        ps=connect.prepareStatement(query);
        ps.setString(1, val);
        ps.setString(2, id);
        int ra=ps.executeUpdate();
        if(ra>0)
        System.out.println("Updated sucessfully!");
        else{
            System.out.println("Error occured try later!");
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
