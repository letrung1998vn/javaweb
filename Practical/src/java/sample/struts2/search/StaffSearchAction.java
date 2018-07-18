/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.search;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tbl_Productdao.SearchDao;
import tbl_Productdto.tbl_ProductDTO;

/**
 *
 * @author letru
 */
public class StaffSearchAction {
    private String searchValue;
    private List<tbl_ProductDTO> products;
    public StaffSearchAction() {
        
    }
    
    public String execute() throws Exception {
       SearchDao dao=new SearchDao();
        try {
            products=dao.SearchName(searchValue);
        } catch (SQLException ex) {
            Logger.getLogger(StaffSearchAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "success";
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<tbl_ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<tbl_ProductDTO> products) {
        this.products = products;
    }

}
