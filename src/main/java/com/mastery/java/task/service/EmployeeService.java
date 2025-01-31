package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.EmployeeServiceNotFoundException;
import com.mastery.java.task.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(String firstName, String lastName) {
        return employeeRepository.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        if (!employeeById.isPresent()) {
            throw new EmployeeServiceNotFoundException("Employee with id = " + id + " doesn't exist in DB");
        }
        return employeeById.get();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeServiceNotFoundException("Employee with id = " + id + " doesn't exist in DB");
        }
        employeeRepository.deleteById(id);
    }

    public void updateEmployeeById(Employee employee, Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeServiceNotFoundException("Employee with id = " + id + " doesn't exist in DB");
        } else {
            Employee employeeById = employeeRepository.getById(id);
            employeeById.setFirstName(employee.getFirstName());
            employeeById.setLastName(employee.getLastName());
            employeeById.setDepartmentId(employee.getDepartmentId());
            employeeById.setJobTitle(employee.getJobTitle());
            employeeById.setGender(employee.getGender());
            employeeRepository.save(employeeById);
        }

    }


}
