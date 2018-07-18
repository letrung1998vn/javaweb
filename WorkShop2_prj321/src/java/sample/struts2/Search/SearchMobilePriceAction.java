/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.Search;

import DAO.MobileDAO;
import DTO.tbl_MoblieDTO;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
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
    @Result(name = "success", location = "jsp/UserSearch.jsp")
})
public class SearchMobilePriceAction {

    private int priceMin;
    private int priceMax;
    private List<tbl_MoblieDTO> mobiles;

    public SearchMobilePriceAction() {
    }

    @Action("/SearchPrice")
    public String execute() throws Exception {
        MobileDAO dao = new MobileDAO();
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        if (priceMin != 0) {
            if (priceMax != 0) {
                mobiles = dao.SearchMobileByPrice(priceMin, priceMax);
            } else {
                mobiles = dao.SearchMobileByPriceMax(priceMax);
            }
        } else if (priceMin == 0 && priceMax == 0) {

        } else {
            mobiles = dao.SearchMobileByPriceMin(priceMin);
        }
        session.put("mobiles", mobiles);
        return "success";
    }

    public int getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(int priceMin) {
        this.priceMin = priceMin;
    }

    public int getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(int priceMax) {
        this.priceMax = priceMax;
    }

    public List<tbl_MoblieDTO> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<tbl_MoblieDTO> mobiles) {
        this.mobiles = mobiles;
    }

}
