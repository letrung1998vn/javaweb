/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MobileDAO;
import DTO.tbl_MoblieDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author letru
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

    private final String staffSearch = "/jsp/StaffSearch.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        MobileDAO dao = new MobileDAO();
        String mobileId = request.getParameter("mobileId");
        String url = "";
        try {
            boolean result = dao.DeleteMobile(mobileId);
            if (result) {
                url = staffSearch;
                String filter = request.getParameter("filter");
                if (filter.equals("id")) {
                    SearchMobileById(request, response);
                } else {
                    SearchMobilebyName(request, response);
                }
            }
        } catch (SQLException e) {
            log("DeleteServlet_SQL " + e.getMessage());
        } catch (NamingException e) {
            log("DeleteServlet_Naming " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    private void SearchMobileById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MobileDAO dao = new MobileDAO();
        String SearchValue = request.getParameter("SearchValue");
        try {
            List<tbl_MoblieDTO> mobiles = dao.SearchID(SearchValue);
            boolean id = true;
            request.setAttribute("id", id);
            request.setAttribute("mobiles", mobiles);
        } catch (SQLException e) {
            log("SearchServlet_SearchMobileId_SQL " + e.getMessage());
        }
    }

    private void SearchMobilebyName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MobileDAO dao = new MobileDAO();
        String SearchValue = request.getParameter("SearchValue");
        try {
            List<tbl_MoblieDTO> mobiles = dao.SearchName(SearchValue);
            boolean name = true;
            request.setAttribute("name", name);
            request.setAttribute("mobiles", mobiles);
        } catch (SQLException e) {
            log("SearcgServlet_SearchMobileName_SQL " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
