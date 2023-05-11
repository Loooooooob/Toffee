import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class itemDB {
    private String DataSource="Items.txt";
    private Map<String, Map.Entry<Integer, Integer>> items = new HashMap<>(); /* name ,(price,quantiy) */    
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
                    items.put(NameOFItem,new AbstractMap.SimpleEntry<>(Integer.parseInt(Price),Integer.parseInt(quantiy)));
                }
            }
            myline.close();
            for (Map.Entry<String, Map.Entry<Integer, Integer>> entry : items.entrySet()) {
                String key = entry.getKey();
                int value1 = entry.getValue().getKey();
                int value2 = entry.getValue().getValue();
                System.out.println(key + " -> (" + value1 + ", " + value2 + ")");
            }
        } catch (Exception e) {
            System.out.println("Couldn't open the File");
        }
        saveItem();
    }
    public void saveItem(){
        try {
            FileWriter itemsfFile = new FileWriter(DataSource, false);
            itemsfFile.write("");
            itemsfFile.close();
            
            
            itemsfFile=new FileWriter(DataSource,true);
            
            for (Map.Entry<String, Map.Entry<Integer, Integer>> entry : items.entrySet()) {
                String NameOfItem = entry.getKey();
                int Price = entry.getValue().getKey();
                int Quantity = entry.getValue().getValue();
                itemsfFile.write(NameOfItem+" "+Price+" "+Quantity+"\n");
            }
           itemsfFile.close();
        } 
        catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
    // +savecategory(mycatg:categories):void
    // +removecategroy(name:string):void
}
