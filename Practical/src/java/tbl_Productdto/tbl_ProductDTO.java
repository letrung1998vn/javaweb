/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tbl_Productdto;

import java.sql.Date;

/**
 *
 * @author letru
 */
public class tbl_ProductDTO {

    String id;
    String name;
    String description;
    float price;
    Date releasedDate;
    Date expiredDate;
    int barCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public tbl_ProductDTO(String id, String name, String description, float price, Date releasedDate, Date expiredDate, int barCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.releasedDate = releasedDate;
        this.expiredDate = expiredDate;
        this.barCode = barCode;
    }

}
