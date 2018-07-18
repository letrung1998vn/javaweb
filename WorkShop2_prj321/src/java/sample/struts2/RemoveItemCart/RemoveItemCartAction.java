/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.RemoveItemCart;

import Cart.CartObj;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author letru
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "jsp/ViewCart.jsp")
})
public class RemoveItemCartAction {

    private String mobileName;
    private final String SUCCESS = "success";

    public RemoveItemCartAction() {
    }

    @Action("/RemoveItemCart")
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        CartObj cart = (CartObj) session.get("cart");
        if (mobileName.contains(",")) {
            String [] Name=mobileName.split(",");
            for(String name:Name){
                name=name.trim();
                cart.removeItemCart(name);
            }
        } else {
            cart.removeItemCart(mobileName);
        }
        session.put("cart", cart);
        return SUCCESS;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

}
