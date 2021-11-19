package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.EmployeeServiceNotFoundException;
import com.mastery.java.task.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    public List<Employee> getAllEmployees(Specification<Employee> specification){
        return employeeRepository.findAll(specification);
    };

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
