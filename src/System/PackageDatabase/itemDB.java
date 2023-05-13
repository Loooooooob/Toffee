package System.PackageDatabase;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A class that represents a database of items.
 */
public class itemDB {
    /**
     * The name of the file that contains the item data.
     */
    private String DataSource="Items.txt";

    /**
     * A map that stores the items in the database, where the key is the name of the item and the value is a pair of the item's price and quantity.
     */
    private Map<String, Map.Entry<Double, Integer>> items = new HashMap<>(); /* name ,(price,quantity) */    

    /**
     * Loads the item data from the file specified by `DataSource` into the `items` map.
     */
    public void loadItem(){
        try {    
            File itemsfFile = new File(DataSource);
            Scanner myline = new Scanner(itemsfFile);
            while (myline.hasNextLine()) {
                String data = myline.nextLine();
                if(data.indexOf("Price", 0)!=-1){
                    continue;
                }else{
                    String NameOFItem="",Price="",quantity="";
                    int countSpaces=0;
                    for (int i = 0; i < data.length(); i++) {
                        if(data.charAt(i)==' '){
                            countSpaces++;
                            i++;
                        }
                        if(countSpaces==0){
                            NameOFItem+=data.charAt(i);
                        }else if(countSpaces==1){
                            Price+=data.charAt(i);
                        }else{
                            quantity+=data.charAt(i);;
                        }
                    }
                    items.put(NameOFItem,new AbstractMap.SimpleEntry<>(Double.parseDouble(Price),Integer.parseInt(quantity)));
                }
            }
            myline.close();
        } catch (Exception e) {
            System.out.println("Couldn't open the File");
        }
    }

    /**
     * Saves the item data from the `items` map to the file specified by `DataSource`.
     */
    public void saveItem(){
        try {
            FileWriter itemsfFile = new FileWriter(DataSource, false);
            itemsfFile.write("");
            itemsfFile.close();
            
            
            itemsfFile=new FileWriter(DataSource,true);
            
            for (Map.Entry<String, Map.Entry<Double, Integer>> entry : items.entrySet()) {
                String NameOfItem = entry.getKey();
                double Price = entry.getValue().getKey();
                int Quantity = entry.getValue().getValue();
                itemsfFile.write(NameOfItem+" "+Price+" "+Quantity+"\n");
            }
           itemsfFile.close();
        } 
        catch (IOException e) {
            System.out.println("Couldn't Save the File.");
        }
    }

    /**
     * Gets the price of the item with the specified name.
     * @param NameOfProduct the name of the item
     * @return the price of the item
     */
    public double getPrice(String NameOfProduct){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        Double value = entry.getKey();
        return value;
    }

    /**
     * Gets the quantity of the item with the specified name.
     * @param NameOfProduct the name of the item
     * @return the quantity of the item
     */
    public int getQuntity(String NameOfProduct){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        int value = entry.getValue();
        return value;
    }

    /**
     * Gets the availability of the item with the specified name.
     * @param name the name of the item
     * @return "Available" if the item is available, "Not Available" otherwise
     */
    public String available(String name){
        if(getQuntity(name)>0){
            return "Available";
        }
        return "Not Available";
    }

    /**
     * Checks if an item with the specified name exists in the database.
     * @param name the name of the item
     * @return `true` if the item exists in the database, `false` otherwise
     */
    public boolean isExist(String name){
        if(items.containsKey(name)){
            return true;
        }
        return false;
    }

    /**
     * Increases the quantity of the item with the specified name by the specified quantity.
     * @param NameOfProduct the name of the item
     * @param quantity the quantity by which to increase the item's quantity
     */
    public void increamntQunatity(String NameOfProduct,int quantity){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        int currentValue = entry.getValue();
        double Price = entry.getKey();
        int updatedValueQuantity = currentValue + quantity;
        items.put(NameOfProduct,new AbstractMap.SimpleEntry<>(Price,updatedValueQuantity));
    }

    /**
     * Decreases the quantity of the item with the specified name by the specified quantity.
     * @param NameOfProduct the name of the item
     * @param quantity the quantity by which to decrease the item's quantity
     */
    public void decreamntQunatity(String NameOfProduct,int quantity){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        int currentValue = entry.getValue();
        double Price = entry.getKey();
        int updatedValueQuantity = currentValue - quantity;
        items.put(NameOfProduct,new AbstractMap.SimpleEntry<>(Price,updatedValueQuantity));
    }
}