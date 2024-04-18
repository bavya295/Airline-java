import java.sql.*;
public class CreateFlightData extends DBoperations implements insert{
    String name;
     String source;
    String destination;
     String arrival;
    String departure;
     String duration;
     String id;
    public CreateFlightData(String id,String name, String source,String destination, String arrival,String departure, String duration)
    {
      this.id=id;
        this.name=name;
        this.source=source;
         this.destination=destination;
         this.arrival=arrival;
         this.departure=departure;
         this.duration=duration;

    }
public void createDetails()
{
  try{
    String query= " insert into Flight values(?,?,?,?,?,?,?)";
    ps=connect.prepareStatement(query);
    ps.setString(1,id);
    ps.setString(2,name);
    ps.setString(3,source);
    ps.setString(4,destination);
    ps.setString(5,arrival);
    ps.setString(6,departure);
    ps.setString(7,duration);
   
    int rowsaffected= ps.executeUpdate();
    if(rowsaffected>0)
    System.out.println("Inserted Sucesfully");
    else
    System.out.println("Some problem occured ! try later");
  }
  catch (Exception e){
System.out.println(e);
  }
}

}
