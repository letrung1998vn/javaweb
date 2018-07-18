/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.registration.RegistrationCreateError;
import sample.registration.RegistrationDAO;

/**
 *
 * @author letru
 */
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {

    private final String errorpage = "CreateNewAccount.jsp";
    private final String loginPage = "login.html";

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
        String userName = request.getParameter("txtUserName");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullName");

        String url = errorpage;
        RegistrationCreateError errors = new RegistrationCreateError();
        boolean error = false;
        try {
            //kiem tra 4 loi cua nguoi dung
            if (userName.trim().length() < 6 || userName.trim().length() > 20) {
                error = true;
                errors.setUserNameLengthError("User Name is required from 6 to 20 characters");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                error = true;
                errors.setPasswordLengthError("PassWord is required from 6 to 30 characters");
            } else if (!confirm.equals(password)) {
                error = true;
                errors.setConfirmLengthError("Confirm value must be match with password value");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 30) {
                error = true;
                errors.setFullNameLengthError("Full Name is required from 2 to 30 characters");
            }
            if (error) {
                request.setAttribute("CREATEERROR", errors);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.createAccount(userName, password, fullname, false);
                if (result) {
                    url = loginPage;
                }
            }
        } catch (SQLException e) {
            log("CreateAccountServlet_SQL " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                errors.setUserNameisExist(userName + "is existed");
                request.setAttribute("CREATEERROR", errors);
            }
        } catch (NamingException e) {
            log("CreateAccountServlet_Naming " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
