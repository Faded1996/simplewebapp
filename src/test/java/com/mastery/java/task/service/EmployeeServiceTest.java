/*
package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.exceptions.NonExistentEmployeeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

//@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
//    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void getAllEmployeesShouldReturnListOfEmployeesIfNotEmpty() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employeeList.add(employee1);
        employeeList.add(employee2);

//        Mockito.when(employeeDao.getAllEmployees()).thenReturn(employeeList);
        List<Employee> result = employeeService.getAllEmployees();
        Assertions.assertEquals(result, employeeList);
    }

    @Test
    public void getAllEmployeesShouldReturnNullIsListOfEmployeesEmpty() {
        List<Employee> emptyEmployeeList = new ArrayList<>();
//        Mockito.when(employeeDao.getAllEmployees()).thenReturn(emptyEmployeeList);
        List<Employee> result = employeeService.getAllEmployees();
        Assertions.assertEquals(result, emptyEmployeeList);
    }

    @Test
    public void getEmployeeByIdShouldReturnEmployeeIfExists() {
        Long employeeId = 1L;
        Employee employee = new Employee(employeeId, "John", "White", 33L, "HR", Gender.MALE);
//        Mockito.when(employeeDao.getEmployeeById(employeeId)).thenReturn(employee);
        Employee result = employeeService.getEmployeeById(employeeId);
        Assertions.assertEquals(result, employee);
    }

    @Test
    public void getEmployeeByIdShouldThrowExceptionIfEmployeeNotExists() {
        Long employeeId = 1L;
//        Mockito.when(employeeDao.getEmployeeById(employeeId)).thenReturn(null);

        NonExistentEmployeeException thrownException =
                Assertions.assertThrows(NonExistentEmployeeException.class, () -> {
                    employeeService.getEmployeeById(employeeId);
                });
        Assertions.assertEquals("Employee with id = 1 doesn't exist in DB", thrownException.getMessage());
    }


    @Test
    public void addEmployeeTest() {
        Employee employee = new Employee(1L, "Philip", "Jones", 78L, "HR", Gender.MALE);
        employeeService.addEmployee(employee);
//        Mockito.verify(employeeDao, Mockito.times(1)).addEmployee(employee);
    }

    @Test
    public void deleteEmployeeByIdShouldDeleteWhenEmployeeExists() {
        Long employeeId = 1L;
        Employee employee = new Employee(employeeId, "Philip", "Jones" +
                "", 78L, "HR", Gender.MALE);
//        Mockito.when(employeeDao.getEmployeeById(employeeId)).thenReturn(employee);
        employeeService.deleteEmployeeById(employeeId);
//        Mockito.verify(employeeDao, Mockito.times(1)).deleteEmployeeById(employeeId);
    }

    @Test
    public void deleteEmployeeByIdShouldThrowExceptionWhenEmployeeNotExists() {
        Long employeeId = 1L;
//        Mockito.when(employeeDao.getEmployeeById(employeeId)).thenReturn(null);
        Assertions.assertThrows(NonExistentEmployeeException.class, () -> {
            employeeService.deleteEmployeeById(employeeId);
        });
    }

    @Test
    public void updateEmployeeByIdShouldUpdateEmployeeIfIdExists() {
        Long employeeId = 1L;
        Employee oldEmployee = new Employee(employeeId, "Philip", "Jones",
                78L, "HR", Gender.MALE);
        Employee newEmployee = new Employee(employeeId, "Vasya", "Pupkin", 99L, "HR",
                Gender.MALE);
//        Mockito.when(employeeDao.getEmployeeById(employeeId)).thenReturn(oldEmployee);
//        employeeService.updateEmployeeById(newEmployee, employeeId);
//        Mockito.verify(employeeDao).updateEmployeeById(newEmployee, employeeId);
//        Mockito.verify(employeeDao).getEmployeeById(employeeId);
    }

    @Test
    public void updateEmployeeByIdShouldThrowExceptionIfIdNotExists() {
        Long employeeId = 1L;
        Employee oldEmployee = new Employee(employeeId, "Philip", "Jones",
                78L, "HR", Gender.MALE);
        Employee newEmployee = new Employee(employeeId, "Vasya", "Pupkin", 99L, "HR",
                Gender.MALE);
//        Mockito.when(employeeDao.getEmployeeById(employeeId)).thenReturn(null);
        Assertions.assertThrows(NonExistentEmployeeException.class, () -> {
            employeeService.updateEmployeeById(newEmployee, employeeId);
        });

    }


}
*/
