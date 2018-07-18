/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.strutLogin;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class LoginStrutsActionForm extends org.apache.struts.action.ActionForm {

    private String userName;
    private String passWord;
    /**
     *
     */
    public LoginStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

 
    
    public boolean checkLogin(){
        RegistrationDAO dao= new RegistrationDAO();
        boolean result=false;
        try{
            result=dao.checkLogin(userName, passWord);
        }
        catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(LoginStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
}
