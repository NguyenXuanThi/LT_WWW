package iuh.fit.se.bai2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/testdb")
public class Test extends HttpServlet {
    private EntityManagerFactory emf;

    @Override
    public void init() {
        // Tự tạo EMF khi servlet được khởi tạo
        emf = Persistence.createEntityManagerFactory("user-management");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            EntityManager em = emf.createEntityManager();
            resp.getWriter().println("✅ Tomcat kết nối DB thành công!");
            em.close();
        } catch (Exception e) {
            resp.getWriter().println("❌ Lỗi kết nối DB: " + e.getMessage());
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    public void destroy() {
        if (emf != null) emf.close();
    }
}


