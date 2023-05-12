import java.util.Scanner;

public class Payment {
    private double shippingFees=50; 
    private cart myCart=new cart();
    public void Checkout(double Total){
        String Address;
        Scanner in = new Scanner(System.in);
        System.out.println("Total: "+Total+" EGP");
        System.out.println("shippingFees: "+shippingFees+" EGP");
        System.out.println("Subtotal: "+shippingFees+Total+" EGP");
        System.out.print("Please enter The Address you want to ship your order to it:");
        Address=in.nextLine();
        System.out.println("Your order will be shipped in 1-2 days");
        System.out.println("===========================================");
    }
}