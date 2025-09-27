package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import iuh.fit.se.*;

import java.io.File;
import java.io.IOException;

@WebServlet("/DienThoaiFormServlet")
@MultipartConfig
public class DienThoaiFormServlet extends HttpServlet {
    private final DienThoaiDAO dao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/DienThoaiForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String maDT = req.getParameter("maDT");
        String tenDT = req.getParameter("tenDT");
        int namSX = Integer.parseInt(req.getParameter("namSX"));
        String cauHinh = req.getParameter("cauHinh");
        String maNCC = req.getParameter("maNCC");

        Part filePart = req.getPart("hinhAnh");
        String fileName = filePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("/images");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        filePart.write(uploadPath + File.separator + fileName);

        DienThoai dt = new DienThoai(maDT, tenDT, namSX, cauHinh, maNCC, fileName);
        dao.insert(dt);

        resp.sendRedirect(req.getContextPath() + "/DanhSachDienThoaiNCCServlet");
    }
}
