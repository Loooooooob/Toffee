import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Login {
    private String username ;
    private String password ;
    // - code : VerifyEmail
    // - Db:DataBase
    public setting modify;
    public void InputData(){
        int choice;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your username: ");
        username= in.nextLine();
        System.out.println();
        while (true) {
            System.out.println("Please choose one option ");
            System.out.println("1 .Enter Password ");
            System.out.println("2 .ForgetPassword ");
            System.out.println("Enter your choice:");
            choice =in.nextInt();
            password= in.nextLine();
            if(choice==1){
                System.out.println("Enter Your Password: ");
                password=in.nextLine();
                if(checklogin()){
                    break;
                }else{
                    System.out.println("Please Try Again");
                }
            }else{
                VerifyEmail();
            }
        }
        System.out.println("Login successfully");
    }
    public void setUsername(String name){
        username=name; 
    }
    public void SetPassword (String pass){
        password=pass;
    }
    public String getUsername(){
        return username; 
    }
    public void getPassword (String pass){
        password=pass;
    }
    public void set_forgetPassword(){

    }
    public boolean checklogin(){
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
          } catch (FileNotFoundException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
          }
          return Find;
    }
    public void VerifyEmail(){
        while(true){
            int code;
            Random rand = new Random();
            int RandomCode;       // Generate random number
            Scanner in = new Scanner(System.in);
            System.out.println("We send to you verification code on your Email");
            RandomCode=rand.nextInt(100000);
            System.out.println("code is: "+RandomCode);
            System.out.println("Enter Verification Code: ");
            code=in.nextInt();
            if(code==RandomCode){
                System.out.println("Correct code");
                System.out.println();
                break;
            }else{
                System.out.println("Not Correct code !");
                System.out.println("Please Try Again");
                System.out.println();
            }
        }
    }
}
