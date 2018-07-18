package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import model.Book;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html >\r\n");

    String imageURL = application.getInitParameter("imageURL");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bookstore.css\" type=\"text/css\" />\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.9.1.js\"></script>\r\n");
      out.write("        <script src=\"js/bookstore.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"centered\">\r\n");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, true);
      out.write("\r\n");
      out.write("            <br />\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "leftColumn.jsp", out, true);
      out.write("\r\n");
      out.write("            <span class=\"label\">Featured Books</span>\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><span class=\"tooltip_img1\"><img\r\n");
      out.write("                                src=\"");
      out.print(imageURL);
      out.write("/A9781430248064-small_3.png\" /></span></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430239963-small_1.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430247647-small_3.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430231684-small_8.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430249474-small_1.png\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430248187-small_1.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430243779-small_2.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430247401-small_1.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430246596-small_1.png\" /></td>\r\n");
      out.write("                    <td><img src=\"");
      out.print(imageURL);
      out.write("/A9781430257349-small_1.png\" /></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
