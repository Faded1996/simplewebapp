package com.mastery.java.task.listener;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ActiveMQEmployeeConsumer {

    private EmployeeRepository employeeRepository;

    @JmsListener(destination = "${activemq.queue-name}")
    public void consume(Employee employee) {
        log.info("IN: consume() - {}", employee);
        employeeRepository.save(employee);
        log.info("OUT: consume() - employee: {} was successfully added", employee);
    }
}
