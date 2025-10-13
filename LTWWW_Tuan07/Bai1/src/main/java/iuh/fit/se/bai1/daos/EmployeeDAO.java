package iuh.fit.se.bai1.daos;
import iuh.fit.se.bai1.entities.Employee;
import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    Employee getById(int id);
    List<Employee> getAll();
    void update(Employee employee);
    void deleteById(int id);
}
