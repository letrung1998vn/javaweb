/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.delete;

import DAO.MobileDAO;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author letru
 */
@ResultPath("/")
@Results({
    @Result(name = "success", location = "jsp/StaffSearch.jsp",
            type = "redirectAction", params = {
                "namespace", "/",
                "SearchValue", "${#session.lastSearchValue}",
                "filter", "${#session.filter}",
                "actionName", "StaffSearch"})
})

public class DeleteAction {

    private String mobileId;
    private final String SUCCESS = "success";

    public DeleteAction() {
    }

    @Action("/delete")
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        dao.DeleteMobile(mobileId);
        System.out.println(mobileId);
        return SUCCESS;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }


}
