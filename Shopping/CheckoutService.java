package java;

import java.util.HashMap;
import java.util.Map;
public class CheckOutService implements CheckOut {
    private static int orderTotal=0;
    private static HashMap<String,Integer> orderList = new HashMap<>();
    public SpecialOffer soc;

    public CheckOutService(SpecialOffer soc){
        this.soc=soc;
    }
    @Override
    public void scan(String item) {
        if(orderList.isEmpty()){
            orderList.put(item,1);
        }
        else if(orderList.containsKey(item)){
            orderList.put(item,orderList.get(item)+1);
        }
        else{orderList.put(item,1); }
    }

    @Override
    public int calculateMyOrderTotal() {
        for(Map.Entry<String,Integer> entry:orderList.entrySet()){
                String item = entry.getKey();
                int units = entry.getValue();
                orderTotal+= soc.offer(item,units);
            }
        return orderTotal;
    }


}
