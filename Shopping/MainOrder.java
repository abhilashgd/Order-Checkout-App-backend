package shopping;
import java.util.Scanner;

/*
 *
 * Author: Abhilash GD
 * Class for Super Market java.Order
 */
public class MainOrder {
    public static Scanner sc= new Scanner(System.in);

    /*
     * Main method to initialise product List, scan items,calculate order total
     */
    public static void main(String[] args) throws Exception {
        //Initialise Product List
        new ProductList().createList();
        //Select CheckoutService
        CheckOut co = new CheckOutService();
        //Select Offer Service
        co.SpecialOfferServiceInitializer(new SpecialOfferService());
        System.out.println("Enter Number of Products to be scanned");
        int numberOfScans = Integer.valueOf(sc.nextLine());
        System.out.println("Enter products");

        while(numberOfScans-->0) {
            String item = sc.nextLine();
            co.scan(item);
        }
        System.out.println("Order Total: "+co.calculateMyOrderTotal());
    }
}

