package iuh.fit.se.bai2.repositories;

import iuh.fit.se.bai2.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByEmployeeRole(String role);
    List<Employee> findByEmployeeName(String employeeName);
}
