/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.FeedBackDAO;
import DTO.FeedBackDTO;
import Obj.MarkObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author letru
 */
@WebServlet(name = "FeedBackServlet", urlPatterns = {"/FeedBackServlet"})
public class FeedBackServlet extends HttpServlet {

    private final String SendFeedBack = "jsp/SendFeedBack.jsp";
    private final String BackToViewMark = "BackViewMarkServlet";

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
        String url = "";
        FeedBackDAO dao = new FeedBackDAO();
        boolean error = false;
        String subject = "";
        String studentID = (String) session.getAttribute("userName");
        String Content = request.getParameter("Content");
        List<MarkObj> marks = (List<MarkObj>) session.getAttribute("marks");
        String errors = "";
        try {
            String action = request.getParameter("Action");
            if (action.equals("Send")) {
                FeedBackDTO feedback = new FeedBackDTO();
                feedback.setStudentID(studentID);
                LocalDate localDate = LocalDate.now();
                java.sql.Date date = java.sql.Date.valueOf(localDate);
                feedback.setFbDate(date);
                feedback.setStatus(true);
                if (Content.isEmpty()) {
                    error = true;
                    errors = "Content must not be null and lower than 250 characters";
                }
                 if (Content==null) {
                    error = true;
                    errors = "Content must not be null and lower than 250 characters";
                }
                if (Content.length() > 250) {
                    error = true;
                    errors = "Content must not be null and lower than 250 characters";
                }
                if (error) {
                    url = SendFeedBack;
                    request.setAttribute("error", errors);
                } else {
                    for (MarkObj mark : marks) {
                        subject += mark.getSubjectID() + "-" + mark.getSubjectAvg() + "-" + mark.getStatus() + "_";
                    }
                    feedback.setContents(Content + "_" + studentID + "_" + subject);
                    boolean result = dao.addFeedBack(feedback);
                    if (result) {
                        request.setAttribute("success", true);
                        url = BackToViewMark;
                    }
                }
            } else if (action.equals("Remove")) {
                url = SendFeedBack;
                String[] count = request.getParameterValues("RemoveSubject");
                if (count.length == marks.size()) {
                    marks.clear();
                } else {
                    for (String id : count) {
                        int i = Integer.parseInt(id);
                        marks.remove(i);
                    }
                    session.setAttribute("marks", marks);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedBackServlet.class.getName()).log(Level.SEVERE, null, ex);
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
