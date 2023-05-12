import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class itemDB {
    private String DataSource="Items.txt";
    public Map<String, Map.Entry<Double, Integer>> items = new HashMap<>(); /* name ,(price,quantiy) */    
    public void loadItem(){
        try {    
            File itemsfFile = new File(DataSource);
            Scanner myline = new Scanner(itemsfFile);
            while (myline.hasNextLine()) {
                String data = myline.nextLine();
                if(data.indexOf("Price", 0)!=-1){
                    continue;
                }else{
                    String NameOFItem="",Price="",quantiy="";
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
                            quantiy+=data.charAt(i);;
                        }
                    }
                    items.put(NameOFItem,new AbstractMap.SimpleEntry<>(Double.parseDouble(Price),Integer.parseInt(quantiy)));
                }
            }
            myline.close();
        } catch (Exception e) {
            System.out.println("Couldn't open the File");
        }
    }
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
    public double getPrice(String NameOfProduct){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        Double value = entry.getKey();
        return value;
    }
    public int getQuntity(String NameOfProduct){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        int value = entry.getValue();
        return value;
    }
    public String available(String name){
        if(getQuntity(name)>0){
            return "Available";
        }
        return "Not Available";
    }
    public boolean isExist(String name){
        if(items.containsKey(name)){
            return true;
        }
        return false;
    }
    public void increamntQunatity(String NameOfProduct,int quantity){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        int currentValue = entry.getValue();
        double Price = entry.getKey();
        int updatedValueQuantity = currentValue + quantity;
        items.put(NameOfProduct,new AbstractMap.SimpleEntry<>(Price,updatedValueQuantity));
    }
    public void decreamntQunatity(String NameOfProduct,int quantity){
        Map.Entry<Double, Integer> entry = items.get(NameOfProduct);
        int currentValue = entry.getValue();
        double Price = entry.getKey();
        int updatedValueQuantity = currentValue - quantity;
        items.put(NameOfProduct,new AbstractMap.SimpleEntry<>(Price,updatedValueQuantity));
    }
}
