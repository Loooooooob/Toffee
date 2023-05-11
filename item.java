import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class item {
    private String name ;
    private int price ;
    private boolean availabilty;
    private itemDB Product;
    // private int quantityUnits;
    // private double quantityKilo;
    // private ItemDB dbItem ;
    // public void setName(String Name){
    //     name=Name;
    // }
    public String getName(){
        return name;
    }
    // public void setPrice(int Price){
    //     price=Price;
    // } 
    public int getPrice(String name){
        return price;
    }
    // public void setQuantityUnits(int Quantity){
    //     quantityUnits =Quantity;
    // } 
    // public void setquantityKilo(Double Quantity){
    //     quantityKilo=Quantity;
    // } 
    // public int getQuantityUnits(int Quantity){
    //     return quantityUnits;
    // } 
    // public double getquantityKilo(Double Quantity){
    //     return quantityKilo;
    // } 
    public boolean available(String name){
        return availabilty;
    }
}
