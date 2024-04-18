import java.sql.*;
public class DeleteFlight extends DBoperations implements Delete {
    String id;
    public DeleteFlight(String id)
    {
       this.id=id;
    }
    public void deleteDetails()
    {
        try{
        String query="delete from Flight where f_id=?";
        ps=connect.prepareStatement(query);
        ps.setString(1, id);
        int row_aff=ps.executeUpdate();
        if(row_aff>0)
        System.out.println("Flight deleted sucessfully");
        else
        System.out.println("Error occured try again later!");
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}
