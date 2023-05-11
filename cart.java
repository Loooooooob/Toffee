import java.util.*;

public class cart {
    private Map<String, Integer>ItemName = new HashMap<String, Integer>(); 
    private double total=0 ;
    private item myItem;
    // private void placeOrder(){ // هيحاسب خلاص
        // myItem.available()
    // } 
    public void dropItem(String NameOfProduct){
        if (ItemName.containsKey(NameOfProduct)) {
            ItemName.remove(NameOfProduct);
            total-=myItem.getPrice(NameOfProduct);
            System.out.println(NameOfProduct+" is removed from the cart");
        }else{
            System.out.println(NameOfProduct+" is not in cart");
        }
    }
    public void addToMyCart(String NameOfProduct,int HowMany){
        if(HowMany>50 || ItemName.get(NameOfProduct)>50 ){
            System.out.println("Sorry you can't order more than 50 unit from this product");
            System.out.println("please try again");
            System.out.println();
        }else{
            if (ItemName.containsKey(NameOfProduct)) {
                int currentValue = ItemName.get(NameOfProduct);
                int updatedValue = currentValue + HowMany;
                ItemName.put(NameOfProduct, updatedValue);
            }else{
                ItemName.put(NameOfProduct,HowMany);
            }
            total+=myItem.getPrice(NameOfProduct);
            System.out.println(NameOfProduct+" added to the cart");
        }
    }
    public void viewItemsInCart() {
        System.out.printf("%-15S %s\n", "Product Name", "Quantity");
        for (Map.Entry<String, Integer> entry : ItemName.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
    }
    public double getTotal(){
        return total;
    }
}
