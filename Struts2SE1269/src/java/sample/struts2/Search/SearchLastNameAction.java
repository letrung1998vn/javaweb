/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.Search;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import registration.RegistrationDTO;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
@ResultPath("/")
@Results({
    @Result(location = "Search.jsp")
})
public class SearchLastNameAction {
    private String SearchValue;
    private List<RegistrationDTO> listAccount;
    private String SUCCESS="success";
    private String FAIL="fail";
    
    public SearchLastNameAction() {
    }
    @Action("/SearchLastName")
    public String execute() throws Exception {
        RegistrationDAO dao= new RegistrationDAO();
        HttpServletRequest request=ServletActionContext.getRequest();
        dao.searchLastName(SearchValue);
        
        this.listAccount=dao.getListAccount();
        
        return SUCCESS;
    }

    public String getSearchValue() {
        return SearchValue;
    }

    public void setSearchValue(String SearchValue) {
        this.SearchValue = SearchValue;
    }

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    
}
