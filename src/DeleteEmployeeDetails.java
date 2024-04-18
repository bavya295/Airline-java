public class DeleteEmployeeDetails extends DBoperations implements Delete {
    String id;
    public DeleteEmployeeDetails(String id)
    {
       this.id=id;
    }
    public void deleteDetails()
    {
        try{
        String query="delete from Employee where e_id=?";
        ps=connect.prepareStatement(query);
        ps.setString(1, id);
        int row_aff=ps.executeUpdate();
        if(row_aff>0)
        System.out.println("Employee deleted sucessfully");
        else
        System.out.println("Error occured try again later!");
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
