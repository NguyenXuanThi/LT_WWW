package iuh.fit.se.bai1.daos.daoImpl;

import iuh.fit.se.bai1.daos.EmployeeDAO;
import iuh.fit.se.bai1.entities.Employee;
import iuh.fit.se.bai1.entities.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
@Component
public class EmployeeDAOImpl implements EmployeeDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (id, name, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getRole());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET name=?, role=? WHERE id=?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

//    Query row(s) with Rows Mapper
    @Override
    public Employee getByIdRowMapper(int id) {
            String sql = "SELECT * FROM employee WHERE id = ?";
            return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
        }

    @Override
    public List<Employee> getAllRowMapper() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

//    Query row(s) with Direct Mapping
    @Override
    public Employee getByIdDirectMapper(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Employee(
                rs.getInt("id"),
                rs.getString("role"),
                rs.getString("name")
        ), id);
    }

//    Query row(s) with BeanPropertyMapper
    @Override
    public Employee getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?",
                new BeanPropertyRowMapper<>(Employee.class),
                id
        );
    }

    @Override
    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM employee",
                new BeanPropertyRowMapper<>(Employee.class));

    }

}