package iuh.fit.se.bai2.services;

import iuh.fit.se.bai2.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeSevice {
    List<Employee> getAll();

    Optional<Employee> getById(int id);

    List<Employee> getByRole(String role);

    List<Employee> getByName(String name);

    void save(Employee employee);

    void deleteById(int id);
}
