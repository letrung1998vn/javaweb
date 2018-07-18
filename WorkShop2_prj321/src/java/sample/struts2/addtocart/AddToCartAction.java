/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.addtocart;

import Cart.CartObj;
import DTO.tbl_MoblieDTO;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author letru
 */
public class AddToCartAction {

    private String mobileName;
    private String SUCCESS="success";

    public AddToCartAction() {
    }

    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        CartObj cart = (CartObj) session.get("cart");
        if (cart == null) {
            cart = new CartObj();
        }
        cart.addItemCart(mobileName);
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
