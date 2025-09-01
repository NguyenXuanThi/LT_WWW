package fit.se;

import java.util.List;

public class TestCRUD {
    public static void main(String[] args) {
        // Khởi tạo EntityManager từ JPAUtils
        Bai5 bai5 = new Bai5();

        // Lấy tất cả user
        List<User2> users = bai5.getAllUsers();

        // In ra console
        System.out.println("Danh sách users:");
        for (User2 u : users) {
            System.out.println("ID: " + u.getId()
                    + ", Name: " + u.getFirst_name()
                    + ", Age: " + u.getTuoi()
                    + ", Phone: " + u.getPhone());
        }
    }
}
