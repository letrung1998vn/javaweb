/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.Login;

import DAO.LoginDAO;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author letru
 */

public class LoginAction {

    private String userName;
    private String password;
    private final String USERSUCCESS = "user";
    private final String STAFFSUCESS = "staff";
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
        LoginDAO dao = new LoginDAO();
        int result = dao.checkLogin(userName, password);
        String url = FAIL;
        if (result == 0) {
            url = USERSUCCESS;
        } else if (result == 1) {
            url = STAFFSUCESS;
        } else if (result == 2) {
            url = STAFFSUCESS;
        }
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        session.clear();
        session.put("USERNAME", userName);
        return url;
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

}
