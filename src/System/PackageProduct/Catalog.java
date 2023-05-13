package System.PackageProduct;
import java.util.Scanner;
/**
 * A class that represents a catalog of items, which can be viewed by category.
 */
public class Catalog {
    /**
     * An instance of the `item` class, which is used to get the prices and availability of items.
     */
    private item myitem=new item();
    /**
     * Displays the categories of items in the catalog and prompts the user to choose a category.
     */
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
    /**
     * Displays the items in the specified category of the catalog.
     * @param choice the user's choice of category
     */
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