package iuh.fit.se.bai2;

import iuh.fit.se.bai2.entities.Employee;
import iuh.fit.se.bai2.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Bai2Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai2Application.class, args);
    }

    @Bean
    CommandLineRunner run(EmployeeRepository employeeRepository) {
        return args -> {
            Employee emp1 = new Employee();
            emp1.setEmployeeName("Alice");
            emp1.setEmployeeRole("Developer");
            employeeRepository.save(emp1);

            List<Employee> employees = employeeRepository.findAll();
            System.out.println("Danh sách tất cả Employee:");
            employees.forEach(e -> System.out.println(
                    "ID: " + e.getEmployeeId() + ", Name: " + e.getEmployeeName() + ", Role: " + e.getEmployeeRole()
            ));
        };
    }
}

