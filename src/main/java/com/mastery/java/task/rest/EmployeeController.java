package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployeeById(@Valid @RequestBody Employee employee, @PathVariable Long id) {
        employeeService.updateEmployeeById(employee, id);
    }
//Turns out that two GET or two POST methods for the same path are not allowed – even if they have different parameters
//Because of that this method is not showing in Swagger UI
//That's why I added "/search" to the path. I don't know if it's the right thing to do though.
    @GetMapping(path = "/search", params = {"firstName", "lastName" })
    public List<Employee> searchEmployeeByFirstNameAndLastName(
            @And({
                    @Spec(path = "firstName", params = "firstName", spec = Like.class),
                    @Spec(path = "lastName", params = "lastName", spec = Like.class)
            }) Specification<Employee> specification) {

        return employeeService.getAllEmployees(specification);
    }


}
