package shopping;
import java.util.HashMap;
import java.util.Scanner;

public class ProductList {
    private static final HashMap<String,
            Product> plist = new HashMap<>();

    public static HashMap<String,Product> getList(){ return plist;}



    void createList(){
        plist.put("A",new Product("A",50,3,130));
        plist.put("B",new Product("B",30,2,45));
        plist.put("C",new Product("C",20,5,80));
        plist.put("D",new Product("D",15,0,0));
    }
    void addListItem(){}
    void modifyListItem(){}
}

