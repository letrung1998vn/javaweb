/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.CheckOut;

import Cart.CartObj;
import DAO.MobileDAO;
import DAO.OrderDAO;
import DTO.OrderDTO;
import DTO.tbl_MoblieDTO;
import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Result(name = "success", location = "jsp/CheckOut.jsp")
})
public class CheckOutAction {

    private int total;
    private int orderId;
    private final String SUCCESS="success";
    public CheckOutAction() {
    }
@Action("/CheckOut")
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        CartObj cart = (CartObj) session.get("cart");
        MobileDAO mobiledao = new MobileDAO();
        OrderDAO orderdao = new OrderDAO();
        OrderDTO order = orderdao.ShowOrder();
        String Id=order.getOrderId();
        if(Id==null){
            orderId=1;
        } else{
            orderId=Integer.parseInt(Id)+1;
        }
        for (Map.Entry<String, Integer> item : cart.getItem().entrySet()) {
            tbl_MoblieDTO moblie = mobiledao.SearchPrice(item.getKey());
            total += (moblie.getPrice() * item.getValue());
        }
        return SUCCESS;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    

}
