public class CreateEmployeeData extends DBoperations implements insert{
    String name;
    String id;
    int salary;
    String phone;
    public CreateEmployeeData( String name,String id, int salary,String phone)
    {
        this.name=name;
        this.id=id;
        this.salary=salary;
        this.phone=phone;
    }
   public void createDetails()
   {
    try{
        String query= " insert into Employee values(?,?,?,?)";
        ps=connect.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,id);
        ps.setInt(3,salary);
        ps.setString(4,phone);
       
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
