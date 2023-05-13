package System.PackageProduct;
import System.PackageDatabase.itemDB;
/**
 * A class that represents an item in the system.
 */
public class item {
    /**
     * The name of the item.
     */
    private String name ;

    /**
     * An instance of the `itemDB` class, which is used to load item data.
     */
    private itemDB Product=new itemDB();

    /**
     * Gets the name of the item.
     * @return the name of the item
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the price of the item with the specified name.
     * @param Name the name of the item
     * @return the price of the item
     */
    public double getprice(String Name){
        Product.loadItem();
        double p= Product.getPrice(Name);
        return p;
    } 

    /**
     * Gets the availability of the item with the specified name.
     * @param name the name of the item
     * @return "Available" if the item is available, "Not Available" otherwise
     */
    public String available(String name){
        int p= Product.getQuntity(name);
        if(p>0){
            return "Available";
        }
        return "Not Available";
    }
}
