import java.util.*;
import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------WELCOME TO AIRLINE MANAGEMENT SYSTEM---------------------");
        System.out.print("Enter your Email: ");
        String email=sc.nextLine();
        CheckEmail ce = new CheckEmail();
        if(email.equals("bavya295@gmail.com"))
        {
            System.out.println("&&&&&&&&&&&&&&&&& --HELLO ADMIN-- &&&&&&&&&&&&&&&");
            System.out.println("# Kindly press the keys to proceed---> 1. Create 2.Delete 3.Update");
            int admin_key = sc.nextInt();
          
            if(admin_key==1)
            {
                System.out.println("# PRESS 1 FOR ADD FLIGHT----2 FOR ADD EMPLOYEES");
                int add_key=sc.nextInt();
                sc.nextLine();
                if(add_key==1)  //CODE FOR ADDING DETAILS
                {
                    System.out.print("Flight ID: ");
                    String flight_id = sc.nextLine();
                System.out.print("Flight name: ");
                String flight_name = sc.nextLine();
                System.out.print("Flight source: ");
                String flight_source=sc.nextLine();
                System.out.print("Flight destination: ");
                String flight_destination = sc.nextLine();
                System.out.print("Flight arrival: ");
                String arrival = sc.nextLine();
                System.out.print("Flight departure: ");
                String departure= sc.nextLine();
                System.out.print("Flight duration: ");
                String duration =sc.nextLine();

                CreateFlightData cfd = new CreateFlightData(flight_id,flight_name,flight_source,flight_destination,arrival,departure,duration);
                cfd.createDetails();
                }
                else
                {
                    System.out.print("Enter Name: ");
                    String e_name=sc.nextLine();
                    System.out.print("Enter the e_id: ");
                    String e_id=sc.nextLine();
                    System.out.print("Enter salary: ");
                    int e_sal=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter phone no: ");
                    String e_phone = sc.nextLine();
                    CreateEmployeeData ced= new CreateEmployeeData(e_name, e_id, e_sal, e_phone);
                    ced.createDetails();

                }
            }
            else if(admin_key==2) //CODE FOR DELETING DETAILS
            {
                sc.nextLine();
                System.out.println("Enter ID: ");
                 String del_id=sc.nextLine();
                System.out.println("# Enter 1 TO {DELETE FLIGHT} 2 TO {DELETE EMPLOYEE} ");
              int delete_key=sc.nextInt();
              if(delete_key==1)
              {
                DeleteFlight df = new DeleteFlight(del_id);
                df.deleteDetails();
              }
              else{
                DeleteEmployeeDetails de= new DeleteEmployeeDetails(del_id);
                de.deleteDetails();
              }
            }
            else             //CODE FOR UPDATE
            {
                  System.out.println("# Select the Domain you want to update 1--> Flight 2--> Employee");
                  int upd_key= sc.nextInt();
                  if(upd_key==1)
                  {
                        System.out.println("# Enter the field to update: 1->name 2->Source 3->Destination 4->Arrival 5->Departure 6->Duration");
                        int field_upd= sc.nextInt();
                        String f_id=null;
                        String new_name=null;
                        sc.nextLine();
                        System.out.print("Enter Flight ID: ");
                        f_id=sc.nextLine();
                        String query=null;
                        switch (field_upd) {
                            case 1:
                           
                            System.out.print("Enter new name: ");
                                 new_name=sc.nextLine();
                             query = "update Flight set f_name=? where f_id=?";
                                break;
                                case 2:
                           
                            System.out.print("Enter new Source: ");
                                 new_name=sc.nextLine();
                                 query = "update Flight set f_source=? where f_id=?";
                                break;
                                case 3:
                            
                            System.out.print("Enter new Destination: ");
                                 new_name=sc.nextLine();
                                 query = "update Flight set f_destination=? where f_id=?";
                                break;
                                case 4:
                            
                            System.out.print("Enter new Arraival Time: ");
                                 new_name=sc.nextLine();
                                 query = "update Flight set arr=? where f_id=?";
                                break;
                                case 5:
                            
                            System.out.print("Enter new Departure time: ");
                                 new_name=sc.nextLine();
                                 query = "update Flight set dep=? where f_id=?";
                                break;
                                case 6:
                            
                            System.out.print("Enter new duration: ");
                                 new_name=sc.nextLine();
                                 query = "update Flight set duration=? where f_id=?";
                                break;
                        
                            default:
                                break;
                        }
                       
                                UpdateFlight uf = new UpdateFlight(query);
                                uf.updateDetails(f_id, new_name);
                  }
                  else
                  {
                    System.out.println("# Enter the Field 1-> name 2->salary 3->phone");
                    int e_upd=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the Employee ID:");
                    String e_id= sc.nextLine();
                    String upd_val=null;
                    String query1=null;
                    
                    switch (e_upd) {
                        case 1:
                        System.out.print("Enter the updated value: ");
                            upd_val=sc.nextLine();
                        query1="update Employee set e_name=? where e_id=?";
                        break;
                        case 2:
                        System.out.print("Enter new salary: ");
                        int sal= sc.nextInt();
                        query1="update Employee set salary=? where e_id=?";
                        UpdateEmployee ue = new UpdateEmployee(query1);
                        ue.updateSalary(e_id,sal);
                        break;
                        case 3:
                        System.out.print("Enter the updated value: ");
                            upd_val=sc.nextLine();
                        query1="update Employee set e_phone=? where e_id=?";
                        break;
                    
                        default:
                            break;
                    }
                    if(e_upd!=2)
                    {
                        UpdateEmployee ue1 = new UpdateEmployee(query1);
                        ue1.updateDetails(e_id, upd_val);
                    }

                  }
            }
        }
        else
        {
            ce.Validate(email);  //add new user email to database
            System.out.println("Enter 1 to see all Flights");
            System.out.println("Enter 2 to search by source");
            System.out.println("Enter 3 to search by destination");
            System.out.println("Enter 4 to search by Time");
            int user_choice=sc.nextInt();
            sc.nextLine();
            String query2=null;
            String user_select=null;
            switch (user_choice) {
                case 1:
                    query2="select * from Flight";
                    ShowDetails sd= new ShowDetails();
           sd.showAllDetails(query2);
                    break;

                case 2:
                    System.out.println("Enter the Source: ");
                     user_select=sc.nextLine();
                    query2="select * from Flight where f_source=?";
                    break;
                    case 3:
                    System.out.println("Enter the Destination: ");
                    user_select=sc.nextLine();
                    query2="select * from Flight where f_destination=?";
                    break;
                    case 4:
                    System.out.println("Enter the Time: ");
                    user_select=sc.nextLine();
                    query2="select * from Flight where arr=?";  
                    break;
                default:
                    break;
            }
           if(user_choice!=1)
           {
            ShowDetails sd1= new ShowDetails();
            sd1.showFilteredResult(query2,user_select);
           }


        }
        
    }
   
}
