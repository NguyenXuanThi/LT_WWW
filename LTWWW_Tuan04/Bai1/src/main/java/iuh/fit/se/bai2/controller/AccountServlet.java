//package iuh.fit.se.bai2.controller;
//
//import iuh.fit.se.bai2.entities.Account;
//import iuh.fit.se.bai2.daos.impl.AccountDAOImpl;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebServlet(name = "account-servlet", value = "/account-servlet")
//public class AccountServlet extends HttpServlet {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tên-persistence-unit");
//    EntityManager em = emf.createEntityManager();
//    private final AccountDAOImpl dao = new AccountDAOImpl(em);
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Lấy dữ liệu từ form
//        String name1 = request.getParameter("txtFName");
//        String name2 = request.getParameter("txtLName");
//        String email = request.getParameter("txtEmail");
//        String password = request.getParameter("password");
//        String dob = request.getParameter("day") + " " + request.getParameter("month") + " " + request.getParameter("year");
//        String gender = request.getParameter("gender");
//
//        Account acc = new Account(name1, name2, email, password, dob, gender);
//        dao.addAccount(acc);
//
//        request.setAttribute("accounts", dao.getAccountList());
//        RequestDispatcher rd = request.getRequestDispatcher("List.jsp");
//        rd.forward(request, response);
//    }
//
//}
