/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.delete;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class DeleteAccountAction {

    private String userName;
    private String LastSearchValue;
    private String SUCCESS = "success";
    private String FAIL = "fail";

    public DeleteAccountAction() {

    }

    public String execute() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        String url = FAIL;
        try {
            boolean result = dao.DeleteAccount(userName);
            if (result) {
                url = SUCCESS;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DeleteAccountAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DeleteAccountAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastSearchValue() {
        return LastSearchValue;
    }

    public void setLastSearchValue(String LastSearchValue) {
        this.LastSearchValue = LastSearchValue;
    }

}
