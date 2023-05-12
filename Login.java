import java.util.Scanner;

public class Login {
    private String username ;
    private String password ;
    private PersonDB DB=new PersonDB();
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
    public void setUsername(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your username: ");
        username= in.nextLine();
        System.out.println(); 
    }
    public void SetPassword (){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Password: ");
        password=in.nextLine();
    }
    public String getUsername(){
        return username; 
    }
    public void getPassword (String pass){
        password=pass;
    }
}