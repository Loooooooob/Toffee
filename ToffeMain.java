import java.util.Scanner;

public class ToffeMain {
    public static void main(String argv[]){
        System.out.println("Welcome To Toffee Application");
        while (true) {
            int choice;
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your option:");
            System.out.println("1-Sign Up\n2-Login in\n3-View Catalog\n4-Exit Program\n");
            System.out.print("Enter your option: ");
            choice=in.nextInt();
            if(choice==1){
                SignUp sign=new SignUp();
                sign.InputData();
            }else if(choice==2){
                Login log=new Login();
                log.InputData();
                if(log.checklogin()){
                    System.err.println("Welcome to the ToffeApp Mrs "+log.getUsername());
                }else{
                    System.err.println("Wrong Email or Password Please try agin");
                }
            }else if(choice==3){
                
            }else{
                System.out.println("Thanks for Using Toffee Application");
                break;
            }
        } 
        // cart my=new cart();
        // my.addToMyCart();  
        // my.viewItems();
        // my.dropItem("Toffee");
        // my.viewItems();
    }
}   
