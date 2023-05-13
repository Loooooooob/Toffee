package System.PackageRequirments;
import System.PackageDatabase.itemDB;
import System.PackageProduct.item;


import java.util.*;
/**
 * Represents a shopping cart that can be used to add and remove items, view the contents of the cart, and calculate the total cost.
 */
public class cart {
    /**
     * A map that stores the names of the items in the cart and their quantities.
     */
    private Map<String, Integer>ItemName = new HashMap<String, Integer>(); 
    /**
     * The total cost of the items in the cart.
     */
    private double total=0 ;
    /**
     * An instance of the `item` class, which is used to get the prices of items.
     */
    private item myItem=new item();
     /**
     * An instance of the `itemDB` class, which is used to load and save item data.
     */
    private itemDB data=new itemDB();
     /**
     * Removes an item from the cart.
     * @param NameOfProduct the name of the product to remove
     */
    public void dropItem(String NameOfProduct){
        if (ItemName.containsKey(NameOfProduct)){
            data.loadItem();
            data.increamntQunatity(NameOfProduct,ItemName.get(NameOfProduct));
            data.saveItem();
            
            ItemName.remove(NameOfProduct);
            total-=myItem.getprice(NameOfProduct);
            System.out.println(NameOfProduct+" is removed from the cart");
        }else{
            System.out.println(NameOfProduct+" is not in cart");
        }
    }
    /**
     * Adds an item to the cart.
     * @param NameOfProduct the name of the product to add
     * @param HowMany the quantity of the product to add
     */
    public void addToMyCart(String NameOfProduct,int HowMany){
        data.loadItem();
        if(!data.isExist(NameOfProduct)){
            System.out.println("There is no item called "+NameOfProduct);
            System.out.println("Please try again");
            System.out.println("=================================");
            return;
        }
        if(data.available(NameOfProduct)=="Not Available"){
            System.out.println("The items if Not Available Now");
            System.out.println("Please choose anthor item");
            System.out.println("=================================");
            return;
        }
        if(HowMany>50){
            System.out.println("Sorry you can't order more than 50 unit from this product");
            System.out.println("please try again");
            System.out.println("==================================");
        }else{
            if (ItemName.containsKey(NameOfProduct)) {
                int currentValue = ItemName.get(NameOfProduct);
                int updatedValue = currentValue + HowMany;
                ItemName.put(NameOfProduct, updatedValue);
            }else{
                ItemName.put(NameOfProduct,HowMany);
            }
            total+=myItem.getprice(NameOfProduct);
            System.out.println(NameOfProduct+" added to the cart");
            data.decreamntQunatity(NameOfProduct,HowMany);
            data.saveItem();
        }
    }
     /**
     * Displays the contents of the cart.
     */
    public void viewItemsInCart() {
        System.out.println("Your Cart");
        System.out.printf("%-15S %s\n", "Product Name", "Quantity");
        for (Map.Entry<String, Integer> entry : ItemName.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("=================================");
    }
    /**
     * Gets the total cost of the items in the cart.
     * @return the total cost
     */
    public double getTotal(){
        return total;
    }
    /**
    * Gets the number of items in the cart.
    * @return the number of items
    */
    public int getSize(){
        return ItemName.size();
    }
    /**
     * Clears the list of item names in cart.
    */
    public void clear() {
        ItemName.clear();
    }
}
