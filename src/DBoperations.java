import java.sql.*;
public class DBoperations {
    public Connection connect= null;
    public PreparedStatement ps = null;
    public ResultSet rs= null;

    public DBoperations()
    {
        Connect c = new Connect();
       connect= c.gConnection();
    }
}
