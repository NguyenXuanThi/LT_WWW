package fit.se;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "uploadMulti", value = "/uploadMulti")
@MultipartConfig
public class Bai2 extends HttpServlet {
    private String uploadPathToSource;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        uploadPathToSource = "A:\\Projects Java\\LTWWW\\LTWWW_Tuan02\\src\\main\\webapp\\uploads";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File fileSaveDir = new File(uploadPathToSource);
        if (!fileSaveDir.exists()) {fileSaveDir.mkdirs();}
        for (Part part : req.getParts()) {
            String fileName = part.getSubmittedFileName();
            if (fileName != null && !fileName.isEmpty()) {
                part.write(fileSaveDir + File.separator + fileName);
            }
        }
        resp.setContentType("text/plain");
        resp.getWriter().println("Upload thanh cong");
    }


}
