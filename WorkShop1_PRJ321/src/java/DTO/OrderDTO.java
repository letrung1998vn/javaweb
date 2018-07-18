/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author letru
 */
public class OrderDTO {

    String orderId;
    String userId;
    Date orderDate;
    int freight;

    public OrderDTO(String orderId, String userId, Date orderDate, int freight) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDate = orderDate;
        this.freight = freight;
    }

    public OrderDTO() {
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

   
}
