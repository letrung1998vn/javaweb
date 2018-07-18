package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import model.Book;
import model.Category;

public final class leftColumn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    String param1 = application.getInitParameter("param1");
    String param2 = application.getInitParameter("param2");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bookstore.css\" type=\"text/css\" />\r\n");
      out.write("<script src=\"js/bookstore.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.9.1.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<div class=\"leftbar\">\r\n");
      out.write("    <ul id=\"menu\">\r\n");
      out.write("        <li><div>\r\n");
      out.write("                <a class=\"link1\" href=\"");
      out.print(param1);
      out.write("\"> <span class=\"label\"\r\n");
      out.write("                                                           style=\"margin-left: 15px;\">Home</span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </div></li>\r\n");
      out.write("        <li><div>\r\n");
      out.write("                <a class=\"link1\" href=\"");
      out.print(param1);
      out.write("?action=allBooks\"><span\r\n");
      out.write("                        style=\"margin-left: 15px;\" class=\"label\">All Books</span></a>\r\n");
      out.write("            </div></li>\r\n");
      out.write("        <li><div>\r\n");
      out.write("                <span class=\"label\" style=\"margin-left: 15px;\">Categories</span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <ul>\r\n");
      out.write("                ");

                    List<Category> categoryList1 = (List<Category>) application
                            .getAttribute("categoryList");
                    Iterator<Category> iterator1 = categoryList1.iterator();
                    while (iterator1.hasNext()) {
                        Category category1 = (Category) iterator1.next();
                
      out.write("\r\n");
      out.write("                <li><a class=\"label\"\r\n");
      out.write("                       href=\"");
      out.print(param1);
      out.write("?action=category&categoryId=");
      out.print(category1.getId());
      out.write("&category=");
      out.print(category1.getCategoryDescription());
      out.write("\"><span\r\n");
      out.write("                            class=\"label\" style=\"margin-left: 30px;\">");
      out.print(category1.getCategoryDescription());
      out.write("</span></a>\r\n");
      out.write("                </li>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("            </ul></li>\r\n");
      out.write("        <li><div>\r\n");
      out.write("                <span class=\"label\" style=\"margin-left: 15px;\">Contact Us</span>\r\n");
      out.write("\r\n");
      out.write("            </div></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <form class=\"search\">\r\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"search\" /> <input id=\"text\"\r\n");
      out.write("                                                                    type=\"text\" name=\"keyWord\" size=\"12\" /> <span\r\n");
      out.write("                                                                    class=\"tooltip_message\">?</span>\r\n");
      out.write("        <p />\r\n");
      out.write("        <input id=\"submit\" type=\"submit\" value=\"Search\" />\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
