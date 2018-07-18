/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.search;

import java.util.List;
import registration.RegistrationDAO;
import registration.RegistrationDTO;

/**
 *
 * @author Dell
 */
public class SearchLastnameAction {
    private String  searchValue;
    private List <RegistrationDTO> listAccounts;
    
    private final String SUCCESS = "success";

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    

    public List<RegistrationDTO> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(List<RegistrationDTO> listAccounts) {
        this.listAccounts = listAccounts;
    }
    
    public SearchLastnameAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        dao.searchLastName(searchValue);
        
        listAccounts = dao.getListAccounts();
        return SUCCESS;
    }
    
}
