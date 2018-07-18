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
import java.util.Collections;
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
@WebServlet(name = "ViewMarkServlet", urlPatterns = {"/ViewMarkServlet"})
public class ViewMarkServlet extends HttpServlet {

    private final String ViewMark = "jsp/ViewMark.jsp";

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
        String url = "";
        try {
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("userName");
            showMark(request, response, userName);
            SearchStudentName(request, response, userName);
            showCredit(request, response);
            url = ViewMark;
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    private void showMark(HttpServletRequest request, HttpServletResponse response, String studentId)
            throws ServletException, IOException {
        MarkDAO markdao = new MarkDAO();
        SubjectDAO subjectdao = new SubjectDAO();
        try {
            List<MarkObj> marks = markdao.showMark(studentId);
            Map<String, String> subjects = subjectdao.showSubjectName();
            Collections.sort(marks);
            for (int i = 0; i < marks.size(); i++) {
                for (int j = i + 1; j < marks.size(); j++) {
                    if (marks.get(i).getSubjectID().equals(marks.get(j).getSubjectID())) {
                        marks.remove(j);
                    }
                }
            }
            request.setAttribute("marks", marks);
            request.setAttribute("subjects", subjects);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void SearchStudentName(HttpServletRequest request, HttpServletResponse response,
            String studentId)
            throws ServletException, IOException {
        StudentDAO dao = new StudentDAO();
        HttpSession session = request.getSession();
        try {
            String studentName = dao.SearchStudentName(studentId);
            session.setAttribute("studentName", studentName);
            request.setAttribute("firstTime", studentName);
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarkServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void showCredit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MarkDAO markdao = new MarkDAO();
        SubjectDAO subjectdao = new SubjectDAO();
        List<MarkObj> marks = (List<MarkObj>) request.getAttribute("marks");
        try {
            Map<String, Integer> credits = markdao.showCredit(marks);
            request.setAttribute("credits", credits);
        } catch (SQLException ex) {
            Logger.getLogger(ViewMarkServlet.class.getName()).log(Level.SEVERE, null, ex);
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
