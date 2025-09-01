package fit.se;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai4", value = "/bai-4")
public class Bai4 extends HttpServlet {
    @Inject
    private UserService userService;
    public void init(){}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        User user = userService.getUser();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        PrintWriter out = resp.getWriter();
        out.println(json);
    }
    public void destroy() {}
}
