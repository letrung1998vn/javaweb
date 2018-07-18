/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.updatePassRole;

import registration.RegistrationDAO;

/**
 *
 * @author ADMIN
 */
public class UpdatePassRoleAction {
    private String username;
    private String password;
    private boolean chkAdmin;
    private String lastSearchValue;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public UpdatePassRoleAction() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isChkAdmin() {
        return chkAdmin;
    }

    public void setChkAdmin(boolean chkAdmin) {
        this.chkAdmin = chkAdmin;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.updateAccount(username, password, chkAdmin);
        
        if(result) {
            url = SUCCESS;
        }
        return url;
    }
    
}
