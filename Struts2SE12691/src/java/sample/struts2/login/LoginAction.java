/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.login;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import registration.RegistrationDAO;

/**
 *
 * @author Dell
 */
public class LoginAction {
    private String username;
    private String password;
    private final String FAIL = "fail";
    private final String SUCCESS = "success";

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
    
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.checkLogin(username, password);
        
        String url = FAIL;
        if(result) {
            url = SUCCESS;
            
            ActionContext context = ActionContext.getContext();
            Map session = context.getSession();
            session.put("USERNAME", username);
        }
        return url;
    }
    
    
}
