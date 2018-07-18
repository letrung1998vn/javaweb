/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.insert;

import DAO.MobileDAO;
import DTO.tbl_MoblieDTO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author letru
 */
@ResultPath("/")
@ExceptionMappings({
    @ExceptionMapping(exception = "java.sql.SQLException",result = "input")
})
@Results({
    @Result(name = "success", location = "jsp/StaffSearch.jsp",
            type = "redirectAction", params = {
                "actionName", "StaffSearch",
                "namespace", "/",
                "SearchValue", "${mobileId}",
                "filter", "id"})
    ,
     @Result(name = "fail", location = "jsp/Insert.jsp")
    ,
     @Result(name = "input", location = "jsp/Insert.jsp")

})
public class InsertAction extends ActionSupport {

    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private boolean notSale;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public InsertAction() {
    }

    @Action("/submitInsert")
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        String url = FAIL;
        tbl_MoblieDTO mobile = new tbl_MoblieDTO(mobileId, description,
                price, mobileName, yearOfProduction, quantity, notSale);
        boolean result = dao.InsertMobile(mobile);
        if (result) {
            url = SUCCESS;
        }
        return url;
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
