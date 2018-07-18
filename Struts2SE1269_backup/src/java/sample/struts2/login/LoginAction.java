/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.login;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class LoginAction {
    private String userName;
    private String password;
    private final String SUCCESS="success";
    private final String FAIL="fail";
    public LoginAction() {
        
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao= new RegistrationDAO();
        boolean result=dao.checkLogin(userName, password);
        String url=FAIL;
        if(result){
            url=SUCCESS;
        }
        ActionContext context=ActionContext.getContext();
        Map session= context.getSession();
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
