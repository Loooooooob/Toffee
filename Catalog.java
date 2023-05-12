import java.util.Scanner;


public class Catalog {
    private item myitem=new item();
    public void ViewCatalog(){
        int choice;
        Scanner in = new Scanner(System.in);
        System.out.println("Categories");
        System.out.println("1-Chocolate category");
        System.out.println("2-Toffee category");
        System.out.println("3-Candy category");
        System.out.print("Enter your choice: ");
        choice=in.nextInt();
        System.out.println("=================================");
        CategoryItems(choice);
    }
    public void CategoryItems(int choice){
        if(choice==1){
            System.out.println("Chocolate category");
            System.out.printf("%-15s $%s %s\n", "Product Name", "Price","Availabilty");
            System.out.printf("%-15s $%.2f %s\n", "galaxy", myitem.getprice("galaxy"), myitem.available("galaxy"));
            System.out.printf("%-15s $%.2f %s\n", "cadbury" ,myitem.getprice("cadbury"),myitem.available("cadbury"));
            System.out.printf("%-15s $%.2f %s\n", "kitkat"  ,myitem.getprice("kitkat"),myitem.available("kitkat"));
            System.out.printf("%-15s $%.2f %s\n", "nutella" ,myitem.getprice("nutella"),myitem.available("nutella"));
            System.out.println("===============================");
        }else if(choice==2){
            System.out.println("Toffee category");
            System.out.printf("%-15s $%s %s\n", "Product Name", "Price","Availabilty");
            System.out.printf("%-15s $%.2f %s\n", "toffee"   ,myitem.getprice("toffee"),myitem.available("toffee"));
            System.out.printf("%-15s $%.2f %s\n", "lollipop" ,myitem.getprice("lollipop"),myitem.available("lollipop"));
            System.out.printf("%-15s $%.2f %s\n", "gum"      ,myitem.getprice("gum"),myitem.available("gum"));
            System.out.println("===============================");
        }else if(choice==3){
            System.out.println("Candy category");
            System.out.printf("%-15s $%S %s\n", "Product Name", "Price","Availabilty");
            System.out.printf("%-15s $%.2f %s\n", "gateau",myitem.getprice("gateau"),myitem.available("gateau"));
            System.out.printf("%-15s $%.2f %s\n", "torta" ,myitem.getprice("torta"),myitem.available("torta"));
            System.out.printf("%-15s $%.2f %s\n", "donuts",myitem.getprice("donuts"),myitem.available("donuts"));
            System.out.println("===============================");
        }     
    }
}