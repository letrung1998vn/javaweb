/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author letru
 */
public class CartObj {
    private String customerID;
    private Map<String,Integer> item;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Map<String, Integer> getItem() {
        return item;
    }

    public void setItem(Map<String, Integer> item) {
        this.item = item;
    }

    public void addItemCart(String title){
        if(this.item==null){
            this.item=new HashMap<>();
        }
        int quality=1;
        if(this.item.containsKey(title)){
            quality=this.item.get(title)+1;
        }
        this.item.put(title,quality);
    }
    public void removeItemCart(String title){
        if(this.item==null){
            return;
        }
        if(this.item.containsKey(title)){
            this.item.remove(title);
            if(this.item.isEmpty()){
                this.item=null;
            }
        }
    }
    
}
