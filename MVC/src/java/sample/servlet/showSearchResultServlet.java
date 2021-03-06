/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import registration.RegistrationDTO;

/**
 *
 * @author letru
 */
@WebServlet(name = "showSearchResultServlet", urlPatterns = {"/showSearchResultServlet"})
public class showSearchResultServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result</h1>");

            String seachValue = request.getParameter("txtSearchValue");

            out.println("Your Search value is:" + seachValue);
            out.println("  <table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>No.</th>");
            out.println("<th>UserName</th>");
            out.println("<th>Password</th>");
            out.println("<th>LastName</th>");
            out.println("<th>Role</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCHRESULT");
            if (result != null) {
                int count = 0;
                for (RegistrationDTO dto : result) {
                    out.println("<tr>");
                    out.println("<th>"
                            + ++count
                            + "</th>");
                    out.println("<th>"
                            + dto.getUserName()
                            + "</th>");
                    out.println("<th>"
                            + dto.getPassword()
                            + "</th>");
                    out.println("<th>"
                            +dto.getLastName()
                            + "</th>");
                    out.println("<th>"
                            + dto.isIsAdmin()
                            + "</th>");
                    out.println("</tr>");
                }
            } else {
                out.println("The result is not found");
            }
            out.println("</tbody>");
            out.println("</table>");

            out.println("</body>");
            out.println("</html>");

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
