import java.util.Scanner;

public class Payment {
    private int shippingFees=50; 
    private cart myCart;
    public void Checkout(){
        System.out.println("Total: "+myCart.getTotal()+" EGP");
        System.out.println("shippingFees: "+shippingFees+" EGP");
        System.out.println("Subtotal: "+shippingFees+myCart.getTotal()+" EGP");
    }
    public Boolean payCash(){
        Scanner in = new Scanner(System.in);
        double pay;
        System.out.println("Please enter your cash: ");
        pay=in.nextDouble();
        if(pay>=shippingFees+myCart.getTotal()){
            System.out.println("The rest of the bill is "+(pay-(shippingFees+myCart.getTotal()))+" EGP");
            return true;
        }
        return false;
    }
}
