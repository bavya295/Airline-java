import java.sql.*;
public class Connect {
    public Connection gConnection()
    {
        Connection connect=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/Airline",
            "root", "Bavya@123");
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return connect;
    }
    
}
