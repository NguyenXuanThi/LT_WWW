package iuh.fit.se.bai2.controller;

import iuh.fit.se.bai2.entities.Account;
import iuh.fit.se.bai2.daos.impl.AccountDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/account-servlet")
public class AccountServlet extends HttpServlet {

    @Resource(name = "jdbc/userdb")   // lấy DataSource đã khai báo trong context.xml
    private DataSource dataSource;

    private AccountDAOImpl dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new AccountDAOImpl(dataSource); // truyền DataSource vào DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy dữ liệu từ form
        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        LocalDate dob = null;
        try {
            if (day != null && month != null && year != null &&
                    !day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
                dob = LocalDate.of(Integer.parseInt(year),
                        Integer.parseInt(month),
                        Integer.parseInt(day));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Account.Gender gender = Account.Gender.valueOf(request.getParameter("gender"));

        Account acc = new Account(0, fname, lname, email, password, dob, gender);
        dao.addAccount(acc);

        request.setAttribute("accounts", dao.findAll());
        request.getRequestDispatcher("List.jsp").forward(request, response);
    }
}

