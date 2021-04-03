package java;

import java.util.HashMap;

public class SpecialOfferCalculator implements SpecialOffer {
    private HashMap<String, Product> productList = ProductList.getList();

    @Override
    public int offer(String item, int units) {
        Product p = productList.get(item);
        int total = 0;
        if (p == null) {
            System.out.println("no match found");
            return 0;
        }
        int offerUnits = p.getOfferUnits();
        if (offerUnits == 0 || offerUnits > units) {
            total += (units * p.getPrice());
        } else {
            if (units%offerUnits == 0) {
                total += (units / offerUnits) * p.getOfferPrice();
            } else {
                total += ((units/offerUnits) * p.getOfferPrice() + units%offerUnits * p.getPrice());
            }
        }
    return total;
    }

}
