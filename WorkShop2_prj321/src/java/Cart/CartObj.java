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

    private String userId;
    private Map<String, Integer> item;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Integer> getItem() {
        return item;
    }

    public void addItemCart(String title) {
        if (this.item == null) {
            this.item = new HashMap<>();
        }
        int quality = 1;
        if (this.item.containsKey(title)) {
            quality = this.item.get(title) + 1;
        }
        this.item.put(title, quality);
    }

    public void removeItemCart(String title) {
        if (this.item == null) {
            return;
        }
        if (this.item.containsKey(title)) {
            if (this.item.get(title).intValue() > 1) {
                int quality = this.item.get(title).intValue() - 1;
                this.item.put(title, quality);
            } else {
                this.item.remove(title);
            }
            if (this.item.isEmpty()) {
                this.item = null;
            }
        }
    }

}
