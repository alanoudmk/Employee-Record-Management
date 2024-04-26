//Data Structure Project
package employeerecordmanagement;
import java.util.InputMismatchException;
import java.util.Scanner;


public class EmployeeRecordManagementProject {
    //fields
    public Node head;       //refrence var point to First node in list
    //Node Class
    public class Node{
        //fields
        private String name,day,phoneNumber,address;
        private double hours,salary;
        private int ID;
        private Node next;  //link Nodes togther
        //constructor Accept Argument
        public Node(int ID,String name,String day,String phone_number,String address,double hours,double salary){
            this.ID=ID;
            this.name=name;
            this.day=day;
            this.phoneNumber=phone_number;
            this.address=address;
            this.hours=hours;
            this.salary=salary;
            this.next=null;
        }
    }
    
    //___________________________________________________________________methods
    //method: chechk if employee alredy in the system
    public boolean checkRecord(int Id_record){
       Node temp=head;      
       if(head==null){
           return false;                     //empty list
       }
       while(temp!=null && head!=null){     //traverse list till end to check if the ID in the list
            if(temp.ID==Id_record){
                return true;
            }
            temp=temp.next;
       }
       return false;
    }
    
    
    //method: Add Employe to Sorted system list
    public void CreateRecord(int ID,String name,String day,String phoneNumber,String address,double hours,double salary){    
        System.out.println("\n\t*Employee Added To Records*");
        Node new_node_record=new Node(ID,name,day,phoneNumber,address,hours,salary);
        
        if( head==null  || head.ID>new_node_record.ID){
            new_node_record.next=head;         //new_node points to head 
            head=new_node_record;              //"become first element"
        }
        else{
            Node temp=head;
            while (temp.next != null && new_node_record.ID>temp.next.ID  ) { //to add it at the end "sorted way"
                   temp = temp.next;
                }
            new_node_record.next=temp.next;    //new_node points to "next of temp" whict is null
            temp.next = new_node_record;       //temp points to new_node
        }    
    }
    
    
    
    
    //method: Search a Record is similar to searching for a key in the linked
    public Node SmartSerchRecord(int serchedID){
        Node temp=head;      
        while (temp!= null) {      
            if( temp.ID == serchedID ){ //if the"key" equal ID? enter
                   return temp;               
            }else{
                   temp=temp.next; //move
            }
        }
        System.out.println("employee with ID #"+serchedID+" is NOT Registered\n");
        temp=null;
        return temp;
    }
    
    
    //method: Delete employee record
    //return: -1->Doesnot exist/null     0->done deleting
    public int DeleteRecored(int deletedID){        
        Node temp=head , prev=null;
            
        if (temp != null && temp.ID == deletedID) {         //if( NOT empty & temp=id user want to deleted)
            head = temp.next;                               //delete First node
            return 0;
        }
        while (temp != null && temp.ID != deletedID) {      //search for key "deletedID" to be deleted
            prev = temp;                                    //prev point to prdecessor of temp
            temp = temp.next;                               //move temp SP; if doesNOT find key "temp will point to null" and exit loop
        }    
        if(temp==null){                                     //if empty? or if key wasnot present in list? EXIT from function
            return -1;                                      
        } 
        prev.next=temp.next;                                //if key found? to delete node: prev Successor point to temp Successor
        return 0;
    }
     
    
    //method:printing all the elements of the Linked list
    public void showRecord(){
        Node temp=head;
        int record_counter=1;
        while( temp!=null ){
              System.out.println("\n-Employee Record "+ record_counter+ " :\n  *ID:"+temp.ID+"\n  *Name:"+temp.name+
                      "\n  *First day of work: "+ temp.day+"\n  *Phone Number: "+temp.phoneNumber+
                      "\n  *Address :"+temp.address+"\n  *Working Hours: "+temp.hours+
                      "\n  *Salary: "+temp.salary+"\n");
            temp=temp.next;
            record_counter++;
        }
       
     }
    
    
    
    
    //method:update the salary of an employee
    public void updateSalary(int serch_ID){       
        Node employee_record = SmartSerchRecord(serch_ID);
        
        if( employee_record == null ){
             return;
        }else{            
            if(employee_record.hours > 32 ){
                double extraHours= employee_record.hours;
                employee_record.salary += (extraHours*0.02*employee_record.salary);
            }
            System.out.println("\n\t*Salary has been calculated and updated Successfully*\n"
                         +"New Salary is: "+ employee_record.salary);
        }
    }   
    
    
    
    //public Node SmartSerchRecord(int serchedID){
    //method:
    public void updateEmployee(int updated_ID){ 
        
            if( !checkRecord(updated_ID) ){
                System.out.println("Employee not found !\n");        
            }
            else{
                Node temp=head;
                    while( temp!=null ){
                        if(temp.ID==updated_ID){
                            break;
                    }
                    temp=temp.next;
            } 
            Scanner input=new Scanner(System.in);
            int choice,flag=1;
            String name,day,phone_number,address;
            double hours,salary;
            
            do{
             System.out.println("\n*Choose what you want to update : \n"+ 
                                "\t1- Employee name  \n"+
                                "\t2- First day of work \n" +
                                "\t3- Phone number \n" +
                                "\t4- Address \n" +
                                "\t5- Work hours \n"+ 
                                "\t6- Salary\n");             
             choice=input.nextInt();
             input.nextLine();
            
             switch(choice){
                 case 1: 
                     System.out.print("\n-Enter the new employee Name: ");  
                     name=input.nextLine();
                     temp.name=name;
                     System.out.println("\t*Emplyee name Successfully updated*\n");
                     break;
                 case 2:
                     System.out.print("\n-Enter the new First day of work: ");  
                     day=input.nextLine();
                     temp.day=day;
                     System.out.println("\t*Emplyee's First day of work Successfully updated*\n");
                     break;
                 case 3:
                      System.out.print("\n-Enter the new Phone number: ");  
                      phone_number=input.nextLine();
                      temp.phoneNumber=phone_number;
                      System.out.println("\t*Emplyee Phone Number Successfully updated*\n");
                      break;
                 case 4:
                      System.out.print("\n-Enter the new Address:");  
                      address=input.nextLine();
                      temp.address=address;
                      System.out.println("\n\t*Emplyee Address Successfully updated*\n");
                      break;
                 case 5:
                      do{
                          System.out.print("\n-Enter the new Working hours **at least 32h** :");
                          hours=input.nextDouble();
                      }while(hours<32);  
                      temp.hours=hours;
                      System.out.println("\n\t*Emplyee new Working hours Successfully updated*"+
                              "\nIf you want to calculate new Salary: \n\t-press '1' \n\t-otherwise press '0' \n");
                      int x = input.nextInt();
                      if(x==1){
                           updateSalary(updated_ID);
                       }
                      break;
                 case 6:
                       System.out.print("\n-Enter the new Salary:");  
                       salary=input.nextDouble();
                       temp.salary=salary;
                       System.out.println("\n\t*Emplyee new Salary value Successfully updated*");
                       break;
                 default : 
                     System.out.println("Wrong choice!");
                     
                 }
             System.out.println("\nDo you want to update another data?\n"
                         + "\t-if YES press 1\n" 
                         + "\t-Otherwise press 0");
                         flag=input.nextInt();
                 
             }while(flag==1);            
         }
    }   
    
    
    
    
    
    
    
    
    
    
//_______________________________________________________________________________________________________________________
    public static void main(String[] args) throws Exception{
        int choice,ID;
        String name,day,phone_number,address;
        double hours,salary;
        boolean flag=true;                                                      //flag for repeating loop
        EmployeeRecordManagementProject ERM = new EmployeeRecordManagementProject();          //creat object from the class                  
        Scanner input=new Scanner(System.in);                                   //to scan user choice
        System.out.println( "*Welcome To Employee Recored Mangment System*");   
        while(flag){
            menu();
            choice=input.nextInt();
            switch(choice){
                    case 1:
                        System.out.print("Enter employee ID: ");  
                        ID=input.nextInt();
                        input.nextLine();
                        
                        if( ERM.checkRecord(ID) ){      //method call to serch if ID alredy in list
                            System.out.println("Employee with ID #"+ID+ " already exist ");
                        }else{                          //if not regiterd yet?
                            System.out.print("Enter Employee Name: ");  
                            name=input.nextLine();
                            System.out.print("Enter First day of work: ");  
                            day=input.nextLine();
                            System.out.print("Enter Phone number: ");  
                            phone_number=input.nextLine();
                            System.out.print("Enter Address: ");  
                            address=input.nextLine();
                            do{
                                System.out.print("Enter Work hours **at least 32h** : " );
                                hours=input.nextDouble();
                            }while(hours<32);
                            System.out.print("Enter Salary: ");  
                            salary=input.nextDouble();
                            ERM.CreateRecord(ID, name, day, phone_number, address, hours, salary); 
                        }
                        break;
                    case 2: 
                        System.out.println("Enter Employee ID To Delete The Recored: ");
                        ID=input.nextInt();
                        
                        if( ERM.DeleteRecored(ID)==0 ){
                            System.out.println("\t*Emplyee Recored has been DELETED*\n");
                            
                        }else{
                            System.out.println("\t*Employee with #"+ID+" doesn't Exist*\n");
                        }
                        break;
                    case 3:
                         System.out.println("Enter Employee ID to Update: ");
                         ID=input.nextInt();
                         ERM.updateEmployee(ID);
                        break;
                    case 4:
                        System.out.println("Enter Employee ID to Update: ");
                        ID=input.nextInt();
                        ERM.updateSalary(ID);
                        break;
                    case 5:
                        System.out.println("Enter employee ID to Search for: ");
                        ID=input.nextInt();
                        
                        Node employee_record = ERM.SmartSerchRecord(ID);
                        if(employee_record !=null){
                            System.out.println("\n*Employee Information:\n  -ID: "+employee_record.ID+"\n  -Name: "+employee_record.name+
                            "\n  -First day of work: "+employee_record.day+"\n  -Phone number: "+employee_record.phoneNumber+
                            "\n  -Address :"+employee_record.address+"\n  -Work hours: "+employee_record.hours+
                            "\n  -Salary: "+employee_record.salary+"\n");
                        }
                        break;
                    case 6:
                        ERM.showRecord();
                        break;
                    case 7:
                        flag=false;  //to exit loop
                        System.out.println("Thank you...\nGOOD BYE");
                        break;
                    default:
                        System.out.println("Wrong choice\n");        
                }
           }     
    }

    
    //method to show menue for user
    public static void menu(){
        System.out.println( "\n***********************************\n"+
                            "\t1- Insert Employee Record\n" +
                            "\t2- Delete Employee Record\n" +
                            "\t3- Update Employee Record\n" +
                            "\t4- Update Employee Salary\n"+
                            "\t5- Search For Specific Employee Record\n" +
                            "\t6- Show All Employees Records\n"+
                            "\t7- Exit\n"+
                            "Enter your choice:");  
    }   
}
