package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import iuh.fit.se.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/DanhSachDienThoaiNCCServlet")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private final DienThoaiDAO dao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String maNCC = req.getParameter("maNCC");
        List<DienThoai> list = (maNCC == null || maNCC.isEmpty())
                ? dao.getAll()
                : dao.getAllByNCC(maNCC);

        req.setAttribute("listDT", list);
        req.getRequestDispatcher("/DanhSachDienThoaiNCC.jsp").forward(req, resp);
    }
}
