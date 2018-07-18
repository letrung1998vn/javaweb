/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Cart.CartObj;
import DAO.MobileDAO;
import DAO.OrderDAO;
import DTO.OrderDTO;
import DTO.OrderDetailDTO;
import DTO.tbl_MoblieDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
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
@WebServlet(name = "OrderServlet", urlPatterns = {"/OrderServlet"})
public class OrderServlet extends HttpServlet {

    private final String UserSearchPage = "jsp/UserSearch.jsp";

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
        OrderDAO orderdao = new OrderDAO();
        MobileDAO mobiledao=new MobileDAO();
        try {
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            String orderId = request.getParameter("orderId");
            String userId = request.getParameter("userId");
            Date orderDate = null;
            orderDate = orderDate.valueOf(request.getParameter("requiredDate"));
            int freight = Integer.parseInt(request.getParameter("freight"));
            OrderDTO order = new OrderDTO(orderId, userId, orderDate, freight);
            orderdao.InsertOrder(order);
            for (Map.Entry<String, Integer> item : cart.getItem().entrySet()) {
                String mobileName = item.getKey();
                tbl_MoblieDTO mobile = mobiledao.SearchMobileName(mobileName);
                OrderDetailDTO orderDetail = new OrderDetailDTO(orderId, mobile.getMobileId(), freight, item.getValue());
                orderdao.InsertOrderDetail(orderDetail);
                int quantity=mobile.getQuantity()-item.getValue();
                mobiledao.UpdateQuantity(mobileName,quantity);     
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        catch (SQLException ex) {
//            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NamingException ex) {
//            Logger.getLogger(OrderServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
        finally {
            RequestDispatcher rd= request.getRequestDispatcher(UserSearchPage);
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
