import java.util.Scanner;

public class ToffeMain {

    public static void main(String argv[]){
        System.out.println("Welcome To Toffee Application");
        boolean logged=false;
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
                logged=true;
            }else if(choice==3){
                int choice2;
                Catalog myCatalog=new Catalog();
                cart myCart=new cart();
                Payment pay=new Payment();
                System.out.println("press 1 to View catalog and buy items");
                System.out.println("press 2 to View catalog only");
                System.out.print("Choose your option:");
                choice2=in.nextInt() ;
                if(choice2==1){
                    if(logged){
                        int quantity;
                        String nameOfProduct;
                        while (true) {
                            myCatalog.ViewCatalog();
                            System.out.print("Enter The Name of the product: ");      
                            nameOfProduct=in.nextLine();
                            System.out.print("Enter The quantity you want: ");      
                            quantity=in.nextInt();
                            int choice3;
                            System.out.println("Press 1 to add the item to the cart");      
                            System.out.println("Press 2 to remove the item from the cart");      
                            System.out.println("Press 3 to close your order");      
                            System.out.print("Choose your option:");
                            choice3=in.nextInt();
                            if(choice3==1){
                                myCart.addToMyCart(nameOfProduct,quantity);
                            }else if(choice3==2){
                                myCart.dropItem(nameOfProduct);
                            }else{
                                break;
                            }
                        }
                        pay.Checkout();
                        if(pay.payCash()){
                            System.out.println("Your order is being prepared");
                        }else{
                            System.out.println("Your cash is not enough please try again");
                        }
                    }
                    else{
                        System.out.print("Please login first :)");      
                    }
                }else{
                    myCatalog.ViewCatalog();
                }
            }else{
                System.out.println("Thanks for Using Toffee Application");
                break;
            }
        } 
    }
}   
