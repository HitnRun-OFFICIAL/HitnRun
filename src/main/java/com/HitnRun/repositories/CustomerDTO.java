public class Customerdata{

    private int CustomerID ;
    private string FirstName ;
    private string LastName ;
    private string Email ;
    private string Phone ;
    private string Username ; 
    private string Password ;

    public CustomerDTO() {
        //constructor
        /*
        CustomerID=0;
        FirstName ="";
        LastName="";
        Email="";
        Phone="";
        Username="";
        Password=""
        */
    }

    public CustomerDTO((int customerID, String firstName, String lastName, String email, String phone, String username, String password) {
        //constructor
        CustomerID= customerID
        FirstName = firstName;
        LastName= lastName;
        Email= email;
        Phone= phone;
        Username= username;
        Password= password;
    }
    public int getCustomerID(){
        return Customerdata;
    }
    public void setCustomerID(int customerID){
        CustomerID = customerID
    }
    public string getFirstName(){
        return FirstName;
    }
    public void setFirstName(string firstName){
        FirstName = firstName
    }
    public string getLastName(){
        return LastName;
    }
    public void setFirstName(string lastName){
        LastName = lastName;
    }
    public string getEmail(){
        return Email;
    }
    public void setFirstName(string email){
        Email = email;
    }
    public string getPhone(){
        return Phone;
    }
    public void setPhone(string phone){
        Phone = phone;
    }
    public string getUsername(){
        return Username;
    }
    public void setUsername(string username){
        Username = username ;
    }
    public string getPassword(){
        return Password;
    }
    public void setPassword(string firstName){
        Password = password ;
    }
}