package System.PackageFeatures;
import java.util.Scanner;

import System.PackageDatabase.PersonDB;

/**
 * A class that represents a login screen for the ToffeApp.
 */
public class Login {
    /**
     * The username entered by the user.
     */
    private String username ;

    /**
     * The password entered by the user.
     */
    private String password ;

    /**
     * An instance of the `PersonDB` class, which is used to check login credentials.
     */
    private PersonDB DB=new PersonDB();

    /**
     * Prompts the user to enter their username and password until a valid login is achieved.
     */
    public void InputData(){
        while(true){
            setUsername();
            SetPassword();
            if(DB.checkUser(username, password)){
                System.err.println("Welcome to ToffeApp Miss,Mrs "+getUsername());
                System.out.println("===========================================");
                break;
            }else{
                System.err.println("Wrong Email or Password Please try again");
            }
        }
        System.out.println("Login successfully");
        System.out.println();
    }

    /**
     * Prompts the user to enter their username.
     */
    public void setUsername(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your username: ");
        username= in.nextLine();
        System.out.println(); 
    }

    /**
     * Prompts the user to enter their password.
     */
    public void SetPassword (){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Password: ");
        password=in.nextLine();
    }

    /**
     * Gets the username entered by the user.
     * @return the username
     */
    public String getUsername(){
        return username; 
    }

    /**
     * Sets the password entered by the user.
     * @param pass the password to set
     */
    public void getPassword (String pass){
        password=pass;
    }
}