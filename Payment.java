import java.util.Scanner;

/**
 * A class that represents a payment screen for an online store.
 */
public class Payment {
    /**
     * The shipping fees for the order.
     */
    private double shippingFees=50; 

    /**
     * Checks out the order and prompts the user to enter their shipping address.
     * @param Total the total cost of the order
     */
    public void Checkout(double Total){
        String Address;
        Scanner in = new Scanner(System.in);
        System.out.println("Total: "+Total+" EGP");
        System.out.println("shippingFees: "+shippingFees+" EGP");
        System.out.println("Subtotal: "+(shippingFees+Total)+" EGP");
        System.out.print("Please enter The Address you want to ship your order to it:");
        Address=in.nextLine();
        System.out.println("Your order will be shipped in 1-2 days");
        System.out.println("=================================");
    }
}