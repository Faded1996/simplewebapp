package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/")
    @ApiOperation(value = "Find all employees or search by first name and/or by last name")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public List<Employee> getAllEmployees(
            @RequestParam(required = false) @Pattern(regexp = "[a-zA-Z]*") String firstName,
            @RequestParam(required = false) @Pattern(regexp = "[a-zA-Z]*") String lastName) {
        log.info("IN: getAllEmployees() - {},{}", firstName, lastName);
        List<Employee> result = employeeService.getAllEmployees(firstName, lastName);
        log.info("OUT: getAllEmployees() - employee list size={}", result.size());
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find employee by Id", notes = "Provide valid Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public Employee getEmployeeById(@PathVariable @Min(1) Long id) {
        log.info("IN: getEmployeeById() - {}", id);
        Employee result = employeeService.getEmployeeById(id);
        log.info("OUT: getEmployeeById() - {}", result);
        return result;
    }

    @PostMapping("/")
    @ApiOperation(value = "Add employee", notes = "Provide valid employee")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public void addEmployee(@Valid @RequestBody Employee employee) {
        log.info("IN addEmployee() - {}", employee);
        employeeService.addEmployee(employee);
        log.info("OUT: addEmployee() - employee {} {} was successfully added", employee.getFirstName(),
                employee.getLastName());
    }

    @DeleteMapping("/{id}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiOperation(value = "Delete employee by Id", notes = "Provide valid Id")
    public void deleteEmployeeById(@PathVariable @Min(1) Long id) {
        log.info("IN: deleteEmployeeById() - {}", id);
        employeeService.deleteEmployeeById(id);
        log.info("OUT: deleteEmployeeById() - employee with id={} was successfully deleted", id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update employee by Id", notes = "Provide valid employee and Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public void updateEmployeeById(@Valid @RequestBody Employee employee, @PathVariable @Min(1) Long id) {
        log.info("IN: updateEmployeeById() - {},{}", employee, id);
        employeeService.updateEmployeeById(employee, id);
        log.info("OUT: updateEmployeeById() - employee with id={} was successfully updated", id);
    }

}
