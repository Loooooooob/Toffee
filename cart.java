import java.util.*;

public class cart {
    private Map<String, Integer>ItemName = new HashMap<String, Integer>(); 
    private double total=0 ;
    private item myItem=new item();
    private itemDB data=new itemDB();
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
    public void viewItemsInCart() {
        System.out.println("Your Cart");
        System.out.printf("%-15S %s\n", "Product Name", "Quantity");
        for (Map.Entry<String, Integer> entry : ItemName.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("=================================");
    }
    public double getTotal(){
        return total;
    }
    public int getSize(){
        return ItemName.size();
    }
}
