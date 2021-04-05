package shopping;

public class Product {
    private String name;
    private int UnitPrice;
    private int offerUnits;
    private int offerPrice;

    Product(String name, int UnitPrice){
        this.name=name;
        this.UnitPrice=UnitPrice;
    }
    Product(String name, int UnitPrice, int offerUnits, int offerPrice){
        this.name=name;
        this.UnitPrice=UnitPrice;
        this.offerUnits=offerUnits;
        this.offerPrice=offerPrice;
    }

    public int getPrice(){return UnitPrice;}
    public int getOfferUnits(){return offerUnits;}
    public int getOfferPrice(){return offerPrice;}
}

