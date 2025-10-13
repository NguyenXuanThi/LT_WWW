package iuh.fit.se.bai2.services.impl;

import iuh.fit.se.bai2.entities.Employee;
import iuh.fit.se.bai2.repositories.EmployeeRepository;
import iuh.fit.se.bai2.services.EmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeSevice {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }
    @Override
    public List<Employee> getByRole(String role) {
        return employeeRepository.findByEmployeeRole(role);
    }
    @Override
    public List<Employee> getByName(String name) {
        return employeeRepository.findByEmployeeName(name);
    }
    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
