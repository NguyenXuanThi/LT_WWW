package iuh.fit.se.ltwww_tuan01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "bai5", urlPatterns = "/bai-5")
public class Bai5 extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("username");
        String first = req.getParameter("first");
        String last = req.getParameter("last");
        String password = req.getParameter("pass");
        String email = req.getParameter("mail");
        String facebook = req.getParameter("fb");
        String shortbio = req.getParameter("bio");
        out.println("<h1> Name: "+ name+"</h1>");
        out.println("<h1> First: "+ first+"</h1>");
        out.println("<h1> Last: "+ last+"</h1>");
        out.println("<h1> Email: "+ email+"</h1>");
        out.println("<h1> Facebook: "+ facebook+"</h1>");
        out.println("<h1> Shortbio: "+ shortbio+"</h1>");
    }

    public void destroy() {}
}
