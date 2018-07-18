/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.delete;

import registration.RegistrationDAO;

/**
 *
 * @author ADMIN
 */
public class DeleteAccountAction {
    private String username;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public DeleteAccountAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.deleteAccount(username);
        String url = FAIL;
        if(result){
            url = SUCCESS;
        }
        return url;
    }
    
}
