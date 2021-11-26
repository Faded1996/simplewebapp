package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.ActiveMQEmployeeProducer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/activemq")
@AllArgsConstructor
@Slf4j
public class ActiveMQEmployeeController {

    private ActiveMQEmployeeProducer producerEmployeeService;

    @PostMapping
    @ApiOperation(value = "Add employee", notes = "Provide valid employee")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public void addEmployee(@Valid @RequestBody Employee employee) {
        log.info("IN: addEmployee() - {}", employee);
        producerEmployeeService.addEmployee(employee);
        log.info("OUT: addEmployee() - employee: {} published successfully", employee);

    }


}
