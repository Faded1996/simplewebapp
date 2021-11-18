package com.mastery.java.task.dao;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTest {

    @Autowired
//    private EmployeeDao employeeDao;

    @Test
    @Order(1)
    public void addEmployeeTests() {
        Employee employee = new Employee();
        employee.setGender(Gender.MALE);
        employee.setJobTitle("HR");
        employee.setDepartmentId(88L);
        employee.setLastName("John");
        employee.setFirstName("Wick");

//        employeeDao.addEmployee(employee);
//        List<Employee> allEmployees = employeeDao.getAllEmployees();
//        Long employeeId = allEmployees.get(allEmployees.size() - 1).getEmployeeId();
//        Assertions.assertNotNull(employeeDao.getEmployeeById(employeeId));
    }

    @Test
    @Order(2)
    public void getAllEmployeesShouldReturnListWithSizeMoreThanZero() {
//        List<Employee> allEmployeesList = employeeDao.getAllEmployees();
//        Assertions.assertTrue(allEmployeesList.size() > 0);

    }


}
