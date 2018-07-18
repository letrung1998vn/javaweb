/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.update;

import DAO.MobileDAO;
import DTO.tbl_MoblieDTO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author letru
 */
public class UpdateAction extends ActionSupport {

    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean notSale;
    private final String SUCCESS = "success";

    public UpdateAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        System.out.println(mobileId);
        System.out.println(description);
        System.out.println(price);
        System.out.println(mobileName);
        tbl_MoblieDTO mobile = new tbl_MoblieDTO(mobileId, description, price,
                mobileName, yearOfProduction, quantity, notSale);
        dao.UpdateMobile(mobile);
        return SUCCESS;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

}
