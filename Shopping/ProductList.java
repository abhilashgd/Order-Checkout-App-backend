package java;

import java.Product;
import java.util.HashMap;
import java.util.Scanner;

public class ProductList {
    private static final HashMap<String,
            Product> plist = new HashMap<>();

    public static HashMap<String,Product> getList(){ return plist;}

    void createList(int N){
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter List Items: Item     Price  Special Offer  ");
        while(N-->0){
            String[] sarr = sc.nextLine().split(" ");
            if(sarr.length ==2){
                plist.put(sarr[0],new Product(sarr[0],Integer.valueOf(sarr[1])));
            }
            else if(sarr.length==5){plist.put(sarr[0],new Product(sarr[0],
                                            Integer.valueOf(sarr[1]),
                                            Integer.valueOf(sarr[2]),
                                            Integer.valueOf(sarr[4])
                                            )); }
        }

    }
    void addListItem(){}
    void modifyListItem(){}
}
