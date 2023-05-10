import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersonDB {
    private String DataSource ="loginCustomers.txt";
    public void saveUser(person customer){
        try {
            FileWriter loginCustomers=new FileWriter(DataSource,true);
            loginCustomers.write(customer.getUsername()+" "+customer.getPassword()+" "+customer.getEmail()+" "+customer.getAddress()+"\n");
            loginCustomers.close();
        } 
        catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
    public boolean checkUser(String username, String password){
        boolean Find=false;
        try {
            File loginCustomers = new File("loginCustomers.txt");
            Scanner myline = new Scanner(loginCustomers);
            while (myline.hasNextLine()) {
              String data = myline.nextLine();
              if(data.indexOf((username+" "+password), 0)!=-1){
                Find=true;
                break;
              }
            }
            myline.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Something went wrong.");
        }
          return Find;
    }
    public boolean checkDoulicateUserName(String username){
        boolean Find=false;
        try {
            File loginCustomers = new File("loginCustomers.txt");
            Scanner myline = new Scanner(loginCustomers);
            while (myline.hasNextLine()) {
              String data = myline.nextLine();
              if(data.indexOf(username, 0)!=-1){
                Find=true;
                break;
              }
            }
            myline.close();
          } catch (FileNotFoundException e) {
            System.out.println("Something went wrong.");
          }
        return Find;
    }
}
