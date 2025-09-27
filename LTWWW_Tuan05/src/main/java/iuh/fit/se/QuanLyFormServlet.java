package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import iuh.fit.se.*;

import java.io.IOException;

@WebServlet("/QuanLyFormServlet")
public class QuanLyFormServlet extends HttpServlet {
    private final DienThoaiDAO dao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("listDT", dao.getAll());
        req.getRequestDispatcher("/QuanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String maDT = req.getParameter("maDT");
        if (maDT != null && !maDT.isEmpty()) {
            dao.delete(maDT);
        }
        resp.sendRedirect(req.getContextPath() + "/QuanLyFormServlet");
    }
}
