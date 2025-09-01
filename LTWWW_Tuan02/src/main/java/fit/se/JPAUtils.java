package fit.se;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {

    private static final EntityManagerFactory emf;

    static {
        // Tên persistence unit phải trùng với persistence.xml
        emf = Persistence.createEntityManagerFactory("www");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Optional: đóng EMF khi ứng dụng tắt
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
