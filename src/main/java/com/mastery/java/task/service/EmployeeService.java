package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.NonExistentEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public Employee getEmployeeById(Long id) {
        Employee employeeById = employeeDao.getEmployeeById(id);
        if (employeeById == null) {
            throw new NonExistentEmployeeException("Employee with id = " + id + " doesn't exist in DB");
        }
        return employeeById;
    }

    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public void deleteEmployeeById(Long id) {
        if (employeeDao.getEmployeeById(id) == null) {
            throw new NonExistentEmployeeException("Employee with id = " + id + " doesn't exist in DB");
        }
        employeeDao.deleteEmployeeById(id);
    }

    public void updateEmployeeById(Employee employee, Long id) {
        if (employeeDao.getEmployeeById(id) == null) {
            throw new NonExistentEmployeeException("Employee with id = " + id + " doesn't exist in DB");
        }
        employeeDao.updateEmployeeById(employee, id);
    }
}
