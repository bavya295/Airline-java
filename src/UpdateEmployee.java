public class UpdateEmployee extends DBoperations implements Update {
    String query;
    public UpdateEmployee(String query)
    {
        this.query=query;
    }
    public void updateDetails(String id, String val)
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
    public void updateSalary(String id,int salary)
    { 
         try{
          ps=connect.prepareStatement(query);
          ps.setInt(1, salary);
          ps.setString(2, id);
          int ra=ps.executeUpdate();
          if(ra>0)
          System.out.print("Salary updated!");
         }
         catch(Exception e)
 {
    System.out.println(e);
 }
    }
}
