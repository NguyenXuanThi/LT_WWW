package iuh.fit.se.bai1;

import iuh.fit.se.bai1.daos.EmployeeDAO;
import iuh.fit.se.bai1.entities.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"iuh.fit.se.bai1.daos.daoImpl", "iuh.fit.se.bai1.daos"})
public class SpringPureJdbcAutoConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringPureJdbcAutoConfigApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO) {
        return args -> {
//            Employee employee = new Employee(8, "Nguyen Van A", "Super Admin");
//            employeeDAO.save(employee);

//            List<Employee> employees = employeeDAO.getAll();
//            employees.forEach(System.out::print);

            Employee employee2 = employeeDAO.getById(8);
            System.out.println(employee2);

            Employee employeeDirectMapper = employeeDAO.getByIdDirectMapper(1);
            System.out.println(employeeDirectMapper);
        };
    }
}
