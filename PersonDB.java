import java.io.FileWriter;
import java.io.IOException;

public class PersonDB {
    private String DataSource ="loginCustomers.txt";
    // +loadUser(): list<user>
    // +loadAdmin(): list<admin>
    public void saveUser(user customer){
        customer.getUsername();
        try {
            FileWriter loginCustomers=new FileWriter(DataSource,true);
            loginCustomers.write(customer.getUsername()+" "+customer.getPassword()+" "+customer.getPassword()+" "+customer.getAddress()+"\n");
            loginCustomers.close();
        } 
        catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
    // +saveadmin(personAdmin:admin):void
    // +removeUser(name:string):void
    // +removeAdmin(name:string):void
    // +checkUser(userName,password):bool
    // +checkAdmin(useradmin,password):bool
}
