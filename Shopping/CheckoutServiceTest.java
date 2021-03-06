package shopping;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutServiceTest {
    HashMap<String,Integer> orderList;
    CheckOutService co;
    SpecialOffer soc;

    @BeforeEach
    void init(){
        co=new CheckOutService();
        soc = new SpecialOfferService();
        new ProductList().createList();
        co.SpecialOfferServiceInitializer(soc);
    }

    @Test
    void scanTest1(){
        co.scan("A");
        co.scan("A");
        co.scan("A");
        co.scan("A");
        co.scan("A");
        co.scan("A");
        assertEquals(1,CheckOutService.getOrderList().size());
    }

    @Test
    void scanTest2(){
        co.scan("A");
        co.scan("A");
        co.scan("B");
        co.scan("B");
        co.scan("C");
        co.scan("C");
        assertEquals(3,CheckOutService.getOrderList().size());
    }

    @Test
    void calculateMyOrderTotalTest1(){
        int orderTotal=0;
        co.scan("A");
        co.scan("A");
        co.scan("B");
        co.scan("B");
        co.scan("C");
        co.scan("C");
     orderTotal=co.calculateMyOrderTotal();
        assertEquals(185,orderTotal);

    }

    @Test
    void calculateMyOrderTotalTest2(){
        int orderTotal=0;
        co.scan("A");
        co.scan("A");
        co.scan("A");
        orderTotal=co.calculateMyOrderTotal();
        assertEquals(130,orderTotal);
    }


    @AfterEach
    void clear(){
        CheckOutService.clearOrderList();
    }

}
