import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;

public class SignUp {
    private String username ;
    private String email ;
    private String password;
    private String address;
    private user customer ;
    // private int code ;
    private OTP code ;
    private PersonDB DB;

    // public boolean  check_registration(){

    // }
    public void InputData(){
        Scanner in = new Scanner(System.in);
        setUserName(username);
        setPassword(password);
        setEmail(email);
        setPassword(password);
        VerifyEmail();
        // customer.
        try {
            FileWriter loginCustomers=new FileWriter("loginCustomers.txt",true);
            loginCustomers.write(username+" "+password+" "+email+" "+address+"\n");
            loginCustomers.close();
        } 
        catch (IOException e) {
            System.out.println("Something went wrong.");
            // e.printStackTrace();
        }
        System.out.println("Resignation successfully");
        System.out.println();
    }
    public void setUserName(String name){
        Scanner in = new Scanner(System.in);
        while(true){
            Boolean validUserName=false;
            System.out.print("Enter Your username: ");
            username= in.nextLine();
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]{4,20}$");
            Matcher valid = pattern.matcher(username);
            if (valid.matches()) {
                System.out.println("The username is valid.");
                validUserName=true;
            } else {
                System.out.println("The username is invalid.");
                System.out.println("Please try anthor one");
            }
            if(validUserName){
                if(checkDoulicateUserName()){
                    System.out.println("This user name is already choosen\nPlease try anthor one\n");
                }else{
                    break;
                }
            }
        } 
    }
    public void setEmail(String Email){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Your Email: ");
            email= in.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            Matcher valid = pattern.matcher(email);
            if (valid.matches()) {
                System.out.println("The email address is valid.");
                break;
            }
            else {
                System.out.println("The email address is invalid.\nPlease try anthor one");
            }
        }
    }
    public void setPassword(String pass){
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Your Password: ");
            password= in.nextLine();
            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");
            Matcher valid = pattern.matcher(password); // check if password matches the excepration
            if (valid.matches()) {
                System.out.println("The password is valid.");
                break;
            } else {
                System.out.println("The password is invalid.");
            }
        }
    }
    public void setAddress(String add){
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
            System.out.println("Enter Verification Code: ");
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
    public boolean checkDoulicateUserName(){
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
        // return false;
    }

}
