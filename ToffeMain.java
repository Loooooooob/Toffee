import java.util.Scanner;

/**
 * The ToffeMain class provides a console interface for the Toffee application.
 * It allows users to sign up, log in, view the catalog, view their cart, contact customer support,
 * and exit the program.
 */
public class ToffeMain {
    public static void main(String argv[]) {
        boolean logged = false;
        Catalog myCatalog = new Catalog();
        cart myCart = new cart();
        Payment pay = new Payment();
        SignUp sign = new SignUp();
        Login log = new Login();
        user User = new user();
        System.out.println("Welcome To Toffee Application");
        while (true) {
            int choice;
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your option:");
            System.out.println("1-Sign Up\n2-Login in\n3-View Catalog\n4-view myitem in cart\n5-Contact us\n6-Exit Program\n");
            System.out.print("Enter your option: ");
            choice = in.nextInt();
            System.out.println("=================================");
            if (choice == 1) {
                sign.InputData();
            } else if (choice == 2) {
                log.InputData();
                logged = true;
            } else if (choice == 3) {
                int choice2;
                System.out.println("press 1 to View catalog and buy items");
                System.out.println("press 2 to View catalog only");
                System.out.print("Choose your option:");
                choice2 = in.nextInt();
                in.nextLine();
                if (choice2 == 1) {
                    if (logged) {
                        int quantity;
                        String nameOfProduct;
                        while (true) {
                            myCatalog.ViewCatalog();
                            int choice3;
                            System.out.println("Press 1 to add the item to the cart");
                            System.out.println("Press 2 to remove the item from the cart");
                            System.out.println("Press 3 Back to the main menu");
                            System.out.print("Choose your option:");
                            choice3 = in.nextInt();
                            System.out.println("=================================");
                            in.nextLine();
                            if (choice3 == 1) {
                                System.out.print("Enter The Name of the product: ");
                                nameOfProduct = in.nextLine();
                                System.out.print("\nEnter The quantity you want: ");
                                quantity = in.nextInt();
                                in.nextLine();
                                myCart.addToMyCart(nameOfProduct.toLowerCase(), quantity);
                            } else if (choice3 == 2) {
                                System.out.print("Enter The Name of the product: ");
                                nameOfProduct = in.nextLine();
                                myCart.dropItem(nameOfProduct);
                                System.out.println("=================================");
                            } else {
                                break;
                            }
                            int ok;
                            if (myCart.getSize() > 0) {
                                System.out.println("Would you like to Pay for orders?");
                                System.err.println("Click 1 for yes");
                                System.err.println("Click 2 for not yet");
                                System.out.print("Choose your option:");
                                ok = in.nextInt();
                                in.nextLine();
                                if (ok == 1) {
                                    myCart.viewItemsInCart();
                                    System.out.println("Order closed");
                                    pay.Checkout(myCart.getTotal());
                                    myCart.clear();
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Please login first :)");
                    }
                } else if (choice2 == 2) {
                    while (true) {
                        int Still;
                        myCatalog.ViewCatalog();
                        System.out.println("To continue browsing the catalog press 1");
                        System.out.println("To exit catalog press 2");
                        System.out.print("Choose your option:");
                        Still = in.nextInt();
                        in.nextLine();
                    }
                }
            } else if (choice == 4) {
                if (logged) {
                    if(myCart.getSize()>0){
                        myCart.viewItemsInCart();
                        System.out.println("=================================");
                    }
                    else{
                        System.out.println("Your Cart is empty !");
                    }
                }else{
                    System.out.println("Please login first :)");
                }
            } else if (choice == 5) {
                User.ContactUs();
                System.out.println("=================================");
            } else {
                System.out.println("Thanks for Using Toffee Application");
                break;
            }
        }
    }
}