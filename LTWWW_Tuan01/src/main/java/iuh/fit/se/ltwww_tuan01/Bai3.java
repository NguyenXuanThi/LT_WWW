package iuh.fit.se.ltwww_tuan01;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai3", value = "/bai-3")
public class Bai3 extends HttpServlet {
    public void init(){}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        User user = new User("Thi", 21,  "123456789");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        PrintWriter out = resp.getWriter();
        out.println(json);
    }
    public void destroy() {}
}
