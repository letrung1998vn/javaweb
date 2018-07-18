/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.update;

import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class UpdateAccountAction {

    private String lastSearchValue;
    private String userName;
    private String password;
    private String lastName;
    private String isAdmin;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public UpdateAccountAction() {
    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        int role = 0;
        String url = FAIL;
        if (isAdmin.equals("true")) {
            role = 1;
        } else if (isAdmin.equals("false")) {
            role = 0;
        }
        boolean result = dao.UpdateAccount(userName, password, role, lastName);

        if (result) {
            url = SUCCESS;
        }
        return url;
    }

    public String getLastSearchValue() {
        return lastSearchValue;
    }

    public void setLastSearchValue(String lastSearchValue) {
        this.lastSearchValue = lastSearchValue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
