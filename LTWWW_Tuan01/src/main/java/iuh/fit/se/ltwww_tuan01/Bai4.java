package iuh.fit.se.ltwww_tuan01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "bai4", urlPatterns = "/bai-4",
//        initParams = {
//        @WebInitParam(name = "Name", value = "Thi"),
//        @WebInitParam(name = "Email", value = "thinguyen28804@gmail.com")
//        }
//)
public class Bai4 extends HttpServlet {
    public void init() throws ServletException {}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //lay context
        ServletContext context = getServletContext();
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Name: "+ context.getInitParameter("Name")+"</h1>");
        out.println("<h1> Email: "+ context.getInitParameter("Email")+"</h1>");


        out.println("<h1> Name: "+ getServletConfig().getInitParameter("Name")+"</h1>");
        out.println("<h1> Email: "+ getServletConfig().getInitParameter("Email")+"</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Name: "+ req.getParameter("name")+"</h1>");
        out.println("<h1> Email: "+ req.getParameter("email")+"</h1>");
        out.println("</body></html>");
    }

    public void destroy(){}
}
