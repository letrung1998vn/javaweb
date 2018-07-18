/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.MarkDAO;
import DAO.StudentDAO;
import DAO.SubjectDAO;
import Obj.MarkObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author letru
 */
@WebServlet(name = "SendFeedBackServlet", urlPatterns = {"/SendFeedBackServlet"})
public class SendFeedBackServlet extends HttpServlet {

    private final String sendFeedBack = "jsp/SendFeedBack.jsp";

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
        HttpSession session = request.getSession();
        String url = sendFeedBack;
        try {
            String[] subjectIDs = request.getParameterValues("subjectID");
            if (subjectIDs != null) {
                String studentId = (String) session.getAttribute("userName");
                ViewDetail(request, response, studentId, subjectIDs);
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    private void ViewDetail(HttpServletRequest request, HttpServletResponse response,
            String studentId, String[] subjectIds)
            throws ServletException, IOException {
        MarkDAO markdao = new MarkDAO();
        SubjectDAO subjectdao = new SubjectDAO();
        HttpSession session = request.getSession();
        try {
            List<MarkObj> marks1 = new ArrayList<>();
            List<MarkObj> marks = new ArrayList<>();
            for (String subjectID : subjectIds) {
                marks1 = markdao.showMarkFeedBack(studentId, subjectID);
                marks.addAll(marks1);
            }
            Map<String, String> subjectName = subjectdao.showSubjectName();
            session.setAttribute("marks", marks);
            session.setAttribute("subjectName", subjectName);
        } catch (SQLException ex) {
            Logger.getLogger(SendFeedBackServlet.class.getName()).log(Level.SEVERE, null, ex);
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
