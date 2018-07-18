/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cart.CartObj;
import DAO.LoginDAO;
import DAO.MobileDAO;
import DAO.OrderDAO;
import DTO.OrderDTO;
import DTO.tbl_MoblieDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author letru
 */
public class Dispatcher extends HttpServlet {

    private final String loginPage = "html/Login.html";
    private final String loginServlet = "LoginServlet";
    private final String SearchServlet = "SearchServlet";
    private final String DeleteServlet = "DeleteServlet";
    private final String UpdateServlet = "UpdateServlet";
    private final String Updatepage = "/jsp/Update.jsp";
    private final String InsertPage = "/jsp/Insert.jsp";
    private final String InsertServlet = "InsertServlet";
    private final String AddtoCartServlet = "AddItemServlet";
    private final String ViewCartPage = "/jsp/ViewCart.jsp";
    private final String AddMoreBookServlet = "AddMoreBookServlet";
    private final String RemoveCartServlet = "RemoveCartServlet";
    private final String OrderServlet = "OrderServlet";
    private final String CheckOutPage = "/jsp/CheckOut.jsp";

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
        String url = loginPage;
        LoginDAO dao = new LoginDAO();
        try {
            String action = request.getParameter("btnAction");
            if (action == null) {

            } else if (action.equals("Login")) {
                url = loginServlet;
            } else if (action.equals("Search")) {
                url = SearchServlet;
            } else if (action.equals("Delete")) {
                url = DeleteServlet;
            } else if (action.equals("Update")) {
                url = Updatepage;
            } else if (action.equals("submit_Update")) {
                url = UpdateServlet;
            } else if (action.equals("Insert")) {
                url = InsertPage;
            } else if (action.equals("Insert Mobile")) {
                url = InsertServlet;
            } else if (action.equals("Add to Cart")) {
                url = AddtoCartServlet;
            } else if (action.equals("View Your Cart")) {
                url = ViewCartPage;
            } else if (action.equals("Add More Book To Your Cart")) {
                url = AddMoreBookServlet;
            } else if (action.equals("Remove")) {
                url = RemoveCartServlet;
            } else if (action.equals("Check Out")) {
                ShowOrder(request, response);
                ShowPrice(request, response);
                ShowMobileId(request, response);
                url = CheckOutPage;
            } else if (action.equals("Order")) {
                url = OrderServlet;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
        }
    }

    private void ShowOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAO orderdao=new OrderDAO();
        try {
            List<OrderDTO> orders = orderdao.ShowOrder();
            request.setAttribute("orders", orders);
        } catch (SQLException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ShowPrice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MobileDAO dao = new MobileDAO();
        int total = 0;
        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            for (Map.Entry<String, Integer> item : cart.getItem().entrySet()) {
                tbl_MoblieDTO moblie = dao.SearchPrice(item.getKey());
                total += (moblie.getPrice() * item.getValue());
            }
            request.setAttribute("total", total);
        } catch (SQLException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ShowMobileId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MobileDAO dao = new MobileDAO();
        String Id="";
        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            for (Map.Entry<String, Integer> item : cart.getItem().entrySet()) {
                tbl_MoblieDTO moblie = dao.SearchMobileName(item.getKey());
                request.setAttribute(item.getKey(), moblie.getMobileId());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
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
