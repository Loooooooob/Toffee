public class item {
    private String name ;
    private itemDB Product=new itemDB();
    public String getName(){
        return name;
    }
    public double getprice(String Name){
        Product.loadItem();
        double p= Product.getPrice(Name);
        return p;
    } 
    public String available(String name){
        int p= Product.getQuntity(name);
        if(p>0){
            return "Available";
        }
        return "Not Available";
    }
}