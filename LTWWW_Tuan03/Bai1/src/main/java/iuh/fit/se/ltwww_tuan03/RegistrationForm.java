package iuh.fit.se.ltwww_tuan03;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public RegistrationForm() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        // Get data from Form
        String fname = request.getParameter("txtFName");
        String lname = request.getParameter("txtLName");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String email = request.getParameter("txtEmail");
        String mobileNumber = request.getParameter("txtMobileNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("txtAddress");
        String city = request.getParameter("txtCity");
        String pinCode = request.getParameter("txtPinCode");
        String state = request.getParameter("txtState");
        String country = request.getParameter("txtCountry");
        String hobbies = request.getParameter("chkHobbies");
        String course = request.getParameter("txtCourse");
        String birthdate = day + " " + month + " " + year;
        String[] levels = {"X", "XII", "Grad", "Masters"};
        Qualification quali1 = null, quali2 = null, quali3 = null, quali4 = null;
        Qualification[] qualis = new Qualification[4];

        for (int i = 0; i < levels.length; i++) {
            String board = request.getParameter("txtBoard" + levels[i]);
            String percent = request.getParameter("txtPercent" + levels[i]);
            String year2 = request.getParameter("txtYear" + levels[i]);

            qualis[i] = new Qualification(board, percent, year2);
        }

        // Set data to Student
        Student sv = new Student();
        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setBirthday(birthdate);
        sv.setQualifications(List.of(qualis));

        // Set object student to request object
        request.setAttribute("student", sv);

        // Forward to result-form.jsp
        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
