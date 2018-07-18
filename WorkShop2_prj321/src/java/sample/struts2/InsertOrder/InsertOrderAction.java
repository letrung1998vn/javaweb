/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.InsertOrder;

import Cart.CartObj;
import DAO.MobileDAO;
import DAO.OrderDAO;
import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.tbl_MoblieDTO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author letru
 */
public class InsertOrderAction extends ActionSupport {

    String orderId;
    String userId;
    int freight;
    private final String SUCCESS = "success";

    public InsertOrderAction() {
    }

    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        CartObj cart = (CartObj) session.get("cart");
        userId = (String) session.get("USERNAME");
        MobileDAO mobiledao = new MobileDAO();
        OrderDAO orderdao = new OrderDAO();
        OrderDTO order = new OrderDTO();
        OrderDetailDTO orderDetail = new OrderDetailDTO();
        LocalDate localDate = LocalDate.now();
        Date orderDate = Date.valueOf(localDate);
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setFreight(freight);
        order.setOrderDate(orderDate);
        orderdao.InsertOrder(order);
        orderDetail.setOrderId(orderId);
        for (Map.Entry<String, Integer> item : cart.getItem().entrySet()) {
            tbl_MoblieDTO mobile = mobiledao.SearchMobileName(item.getKey());
            orderDetail.setMobileId(mobile.getMobileId());
            orderDetail.setQuantity(item.getValue());
            orderDetail.setUnitPrice((int) mobile.getPrice());
            orderdao.InsertOrderDetail(orderDetail);
            mobiledao.UpdateQuantity(item.getKey(), item.getValue());
        }
        session.remove("cart");
        return SUCCESS;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

}
