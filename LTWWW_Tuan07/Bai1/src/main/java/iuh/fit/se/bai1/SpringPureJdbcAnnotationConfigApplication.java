package iuh.fit.se.bai1;

import iuh.fit.se.bai1.daos.EmployeeDAO;
import iuh.fit.se.bai1.entities.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class SpringPureJdbcAnnotationConfigApplication {
    @SuppressWarnings("resoure")
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringPureJdbcAnnotationConfigApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());

        EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);
        Employee employee = new Employee(10, "nhan vien", "Thi");
        employeeDAO.save(employee);
    }
}
