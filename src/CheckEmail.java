import java.sql.*;
public class CheckEmail {
    public void Validate( String email)
    {
        Connect c = new Connect();
        Connection connect_string = c.gConnection();
        String check_query= "select * from Email where email_id= ?";
        PreparedStatement ps= null;
        ResultSet rs = null;
        try{
               ps= connect_string.prepareStatement(check_query);
               ps.setString(1, email);
               rs=ps.executeQuery();
               if(rs.next())
               System.out.print(" Thankyou for using our service again .Email id already exist!");
               else
               {
                ps=connect_string.prepareStatement("insert into Email values(?)");
                ps.setString(1,email);
                int rowsaffected=ps.executeUpdate();
                if(rowsaffected>0)
                System.out.println("Welcome New User! Email added sucessfully");
                else
                System.out.print("Failed to add Email ! TRY LATER");
               }
        }
        catch(Exception e){
            System.err.println(e);
        }
        
    }
}
