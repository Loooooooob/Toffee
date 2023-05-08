import java.util.*;
public class cart {
    private Map<String, Integer>ItemName = new HashMap<String, Integer>();
    private int quantity; 
    private double total ;
    private item myItem;
    private void placeOrder(){
        // myItem.available()
    } 
    public void dropItem(String NameOfProduct){
        ItemName.remove(NameOfProduct);
    }
    public void addToMyCart(){
        ItemName.put("lolipop", 5);
        ItemName.put("chocolate", 7);
        ItemName.put("Toffee", 9);
    }
    public void viewItems() {
        System.out.printf("%-15S %s\n", "Product Name", "Quantity");
        for (Map.Entry<String, Integer> entry : ItemName.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
    }
}
