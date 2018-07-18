/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.Search;

import java.util.List;
import registration.RegistrationDTO;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class SearchLastNameAction {
    private String SearchValue;
    private List<RegistrationDTO> listAccount;
    private String SUCCESS="success";
    private String FAIL="fail";
    
    public SearchLastNameAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao= new RegistrationDAO();
        dao.searchLastName(SearchValue);
        
        this.listAccount=dao.getListAccount();
        
        return SUCCESS;
    }

    public String getSearchValue() {
        return SearchValue;
    }

    public void setSearchValue(String SearchValue) {
        this.SearchValue = SearchValue;
    }

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    
}
