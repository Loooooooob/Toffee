import java.util.Scanner;

public class Catalog {
    // type : list<string>
    public int ViewCatalog(){
        int choice;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Categories");
        System.out.println("1-Chocolate category");
        System.out.println("2-Toffee category");
        System.out.println("3-Candy category");
        System.out.println("Enter your choice: ");
        choice=in.nextInt();
        return choice;
    }
    public void CategoryItems(){

    }
}
