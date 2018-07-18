/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.Search;

import DAO.MobileDAO;
import DTO.tbl_MoblieDTO;
import java.util.List;

/**
 *
 * @author letru
 */
public class StaffSearchAction {

    private String SearchValue;
    private String filter;
    private List<tbl_MoblieDTO> mobiles;
    private final String SUCCESS = "success";

    public StaffSearchAction() {
    }

    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        if (!SearchValue.isEmpty()) {
            if (filter!=null) {
                if (filter.equals("id")) {
                    mobiles = dao.SearchID(SearchValue);
                } else if (filter.equals("name")) {
                    mobiles = dao.SearchName(SearchValue);
                }
            }
        }
        return SUCCESS;
    }

    public String getSearchValue() {
        return SearchValue;
    }

    public void setSearchValue(String SearchValue) {
        this.SearchValue = SearchValue;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public List<tbl_MoblieDTO> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<tbl_MoblieDTO> mobiles) {
        this.mobiles = mobiles;
    }

}
