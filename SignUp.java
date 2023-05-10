import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SignUp {
    private String username ;
    private String email ;
    private String password;
    private String address;
    private user customer=new user() ;
    private OTP code=new OTP() ;
    private PersonDB DB=new PersonDB();

    public void InputData(){
        Scanner in = new Scanner(System.in);
        setUserName();
        setPassword();
        setEmail();
        setAddress();
        VerifyEmail();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setAddress(address);
        DB.saveUser(customer);
        System.out.println("Resignation successfully");
        System.out.println();
    }
    public void setUserName(){
        Scanner in = new Scanner(System.in);
        while(true){
            Boolean validUserName=false;
            System.out.print("Enter Your username: ");
            username= in.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{4,20}$");
            Matcher valid = pattern.matcher(username);
            if (valid.matches()) {
                validUserName=true;
            } else {
                System.out.println("The username is invalid.");
                System.out.println("Please try another one");
            }
            if(validUserName){
                if(DB.checkDoulicateUserName(username)){
                    System.out.println("This user name is already choosen\nPlease try another one\n");
                }else{
                    break;
                }
            }
        } 
    }
    public void setEmail(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Your Email: ");
            email= in.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            Matcher valid = pattern.matcher(email);
            if (valid.matches()) {
                break;
            }
            else {
                System.out.println("The email address is invalid.\nPlease try another one");
            }
        }
    }
    public void setPassword(){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Your Password: ");
            password= in.nextLine();
            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
            Matcher valid = pattern.matcher(password); // check if password matches the excepration
            if (valid.matches()) {
                break;
            } else {
                System.out.println("The password is invalid.\nPlease try another one");
            }
        }
    }
    public void setAddress(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Address: ");
        address= in.nextLine();
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getAddress(){
        return address;
    }
    public void VerifyEmail(){
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
