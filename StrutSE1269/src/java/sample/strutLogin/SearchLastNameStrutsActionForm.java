/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.strutLogin;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import registration.RegistrationDTO;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
public class SearchLastNameStrutsActionForm extends org.apache.struts.action.ActionForm {

    private String searchValue;
    private List<RegistrationDTO> listAccount;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    public void setListAccount(List<RegistrationDTO> listAccount) {
        this.listAccount = listAccount;
    }
    
    /**
     *
     */
    public SearchLastNameStrutsActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void SearchLastName(){
        RegistrationDAO dao= new RegistrationDAO();
        try {
            dao.searchLastName(searchValue);
            this.listAccount=dao.getListAccount();
        } catch (SQLException ex) {
            Logger.getLogger(SearchLastNameStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchLastNameStrutsActionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
}
