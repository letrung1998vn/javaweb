/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MobileDAO;
import DTO.tbl_MoblieDTO;
import Error.InsertError;
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
@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
public class InsertServlet extends HttpServlet {

    private final String InsertPage = "/jsp/Insert.jsp";
    private final String StaffSearch = "/jsp/StaffSearch.jsp";

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
        InsertError errors = new InsertError();
        boolean error = false;
        String url = InsertPage;
        try {
            boolean notSale;
            if (request.getParameter("notSale") == null) {
                notSale = false;
            } else {
                notSale = true;
            }
            String mobileId = request.getParameter("mobileId");
            if (mobileId.isEmpty() || mobileId.length() > 10) {
                error = true;
                errors.setMobileIdLengthError("Mobile Id must be between 1 to 10 character ");
            }
            
            String description = request.getParameter("description");
            if (description.isEmpty() || description.length() > 250) {
                error = true;
                errors.setDescriptionLengthError("Decription must be between 1 to 10 character ");
            }
            
            String mobileName = request.getParameter("mobileName");
            if (mobileName.isEmpty() || mobileName.length() > 20) {
                error = true;
                errors.setMobileNameError("Mobile name must be between 1 to 20 character ");
            }
            
            float price = 0;
            try {
                price = Float.parseFloat(request.getParameter("price"));
                if (price < 0) {
                    error = true;
                    errors.setPriceError("Price must be positive ");
                }
            } catch (NumberFormatException e) {
                error = true;
                errors.setPriceError("Price must be number");
            }
            
            int yearOfProduction = 0;
            try {
                yearOfProduction = Integer.parseInt(request.getParameter("yearOfProduction"));
                if (yearOfProduction < 0) {
                    error = true;
                    errors.setYearofProductionError("Year of Production must be positive ");
                }
            } catch (NumberFormatException e) {
                error = true;
                errors.setYearofProductionError("Year Of Production must be number");
            }
            
            int quantity = 0;
            try {
                quantity = Integer.parseInt(request.getParameter("quantity"));
                if (quantity < 0) {
                    error = true;
                    errors.setQuantityError("Quantity must be positive ");
                }
            } catch (NumberFormatException e) {
                error = true;
                errors.setQuantityError("Quantity Must be number");
            }
            
            if (error) {
                request.setAttribute("errors", errors);
            } else {
                MobileDAO dao = new MobileDAO();
                tbl_MoblieDTO mobile = new tbl_MoblieDTO(mobileId, description,
                        price, mobileName, yearOfProduction, quantity, notSale);
                boolean result = dao.InsertMobile(mobile);
                if (result) {
                    url = StaffSearch;
                    SearchMobileById(request, response);
                }
            }
        } catch (SQLException e) {
            log("InsertServlet_SQL" + e.getMessage());
        } catch (NamingException e) {
            log("InsertServlet_Naming" + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    private void SearchMobileById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MobileDAO dao = new MobileDAO();
        String SearchValue = request.getParameter("mobileId");
        try {
            List<tbl_MoblieDTO> mobiles = dao.SearchID(SearchValue);
            boolean id = true;
            request.setAttribute("id", id);
            request.setAttribute("mobiles", mobiles);
        } catch (SQLException e) {
            log("SearchServlet_SearchMobileId_SQL " + e.getMessage());
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
