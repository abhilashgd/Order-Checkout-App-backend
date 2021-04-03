package java;
import java.util.Scanner;

/*
 *
 * Author: Abhilash GD
 * Class for Super Market java.Order
 */
public class Order {
    public static Scanner sc= new Scanner(System.in);


    private static void initialiseProductList() {
        System.out.println("Enter Number of list items");
        new ProductList().createList(sc.nextInt());
    }


   /*
   * Main method to initialise product List, scan items,calculate order total
    */
    public static void main(String[] args) throws Exception {
        Order.initialiseProductList();
        CheckOut co = new CheckOutService(new SpecialOfferCalculator());
        System.out.println("Enter Number of Products to be scanned");
        while(sc.nextLine()==null)continue;
        int N = Integer.valueOf(sc.nextLine());
        System.out.println("Enter products");

        while(N-->0) {
            String item = sc.nextLine();
            co.scan(item);
        }
        System.out.println("java.Order Total: "+co.calculateMyOrderTotal());
    }


}

