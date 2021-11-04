package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employee where employee_id=?";
        return jdbcTemplate.query(sql, new Object[]{id}, new EmployeeMapper())
                .stream().findAny().orElse(null);
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender)" +
                "values (?, ?, ?, ?, ?) ";
        int rowsAdded = jdbcTemplate.update(sql,
                employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender().name());


//        if (rowsAdded == 1) {
//            System.out.println("Employee " + employee.getFirstName() + " was successfully added to DB");
//        } else System.out.println("Something went wrong");

    }

    public void deleteEmployeeById(Long id) {
        String sql = "DELETE FROM employee WHERE employee_id=?";
        int rowsDeleted = jdbcTemplate.update(sql, id);

//        if (rowsDeleted == 1) {
//            System.out.println("Employee with id " + id + " was successfully deleted");
//        } else System.out.println("Something went wrong");
    }

    public void updateEmployeeById(Employee employee, Long id) {
        String sql = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?" +
                "where employee_id = ?";
        int rowsUpdated =
                jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                        employee.getJobTitle(), employee.getGender().name(), id);

//        if (rowsUpdated == 1) {
//            System.out.println("Employee with id " + id + " was successfully updated");
//        } else System.out.println("Something went wrong");
    }
}
