/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author letru
 */
public class Dispatcher extends HttpServlet {

    private final String loginServlet = "LoginServlet";
    private final String loginPage = "login.html";
    private final String searchServlet = "SearchLastNameServlet";
    private final String deleteServlet = "DeleteAccountServlet";
    private final String UpdateJSP = "Update.jsp";
    private final String UpdateServlet = "UpdateServlet";
    private final String StartOpenServlet = "StartOpenServlet";
    private final String addItemServlet = "AddItemServlet";
    private final String viewCartPage = "ViewCart.jsp";
    private final String RemoveCartServlet = "RemoveCartServlet";
    private final String CreateServlet = "CreateServlet";

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
        String button = request.getParameter("btnAction");
        String url = "";
        try {
            if (button == null) {
                url = StartOpenServlet;
            } else if (button.equals("login")) {
                url = loginServlet;
            } else if (button.equals("Search")) {
                url = searchServlet;
            } else if (button.equals("delete")) {
                url = deleteServlet;
            } else if (button.equals("Update")) {
                url = UpdateJSP;
            } else if (button.equals("submit_Update")) {
                url = UpdateServlet;
            } else if (button.equals("Add to Cart")) {
                url = addItemServlet;
            } else if (button.equals("View Your Cart")) {
                url = viewCartPage;
            } else if (button.equals("Remove Selected Items")) {
                url = RemoveCartServlet;
            } else if (button.equals("Create")) {
                url = CreateServlet;
            }
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
