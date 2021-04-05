package shopping;

public interface CheckOut {
    void SpecialOfferServiceInitializer(SpecialOffer soc);
    void scan(String str);
    int calculateMyOrderTotal();
}

