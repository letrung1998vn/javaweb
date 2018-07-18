/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.login;







/**
 *
 * @author letru
 */
public class LoginAction {

    private String UserName;
    private String Password;
    private final String STAFF = "staff";
    private final String CUSTOMER = "customer";
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
       tbl_Userdao.LoginDAO dao = new tbl_Userdao.LoginDAO();
        String url = FAIL;
        boolean result = dao.checkLogin(UserName, Password);
        if (result) {
            int who = dao.checkwho(UserName, Password);
            if (who == 0) {
                url = CUSTOMER;
            } else if (who == 1) {
                url = STAFF;
            }
        }
        return url;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
