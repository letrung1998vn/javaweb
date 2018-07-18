/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.javabean;

import java.io.Serializable;
import java.sql.SQLException;
import registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class LoginBean implements Serializable{
    private String UserName;
    private String Password;

    public LoginBean() {
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

    
    public boolean checkLogin(){
        RegistrationDAO dao= new RegistrationDAO();
        boolean result;
        try{
            result=dao.checkLogin(UserName, Password);
            return result;
        }
        catch(SQLException e){
            
        }
        return false;
    }
}
