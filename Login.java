import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private String username ;
    private String password ;
    private PersonDB DB=new PersonDB();
    // - code : VerifyEmail
    // - Db:DataBase
    public void InputData(){
        while(true){
            setUsername();
            SetPassword();
            if(checklogin()){
                System.err.println("Welcome to ToffeApp Miss,Mrs "+getUsername());
                System.out.println();
                break;
            }else{
                System.err.println("Wrong Email or Password Please try agin");
            }
        }
        System.out.println("Login successfully");
        System.out.println();
    }
    public void setUsername(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your username: ");
        username= in.nextLine();
        System.out.println(); 
    }
    public void SetPassword (){
        Scanner in = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Please choose one option ");
            System.out.println("1 .Enter Password ");
            System.out.println("2 .ForgetPassword ");
            System.out.print("Enter your choice:");
            choice =in.nextInt();
            password= in.nextLine();
            if(choice==1){
                System.out.print("Enter Your Password: ");
                password=in.nextLine();
                if(DB.checkUser(username, password)){
                    break;
                }else{
                    System.out.println("Please Try Again");
                }
            }else{
                VerifyEmail();
            }
        }
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
        OTP code = new OTP();
        Scanner in = new Scanner(System.in);
        while(true){
            code.setOTP();
            int InCode;
            System.out.println("code is: "+code.getOTP());
            System.out.print("Enter Verification Code: ");
            InCode=in.nextInt();
            if(InCode==code.getOTP()){
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
