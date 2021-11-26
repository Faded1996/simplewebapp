package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
@Slf4j
@AllArgsConstructor
public class ActiveMQEmployeeProducer {

    private JmsTemplate jmsTemplate;
    private Queue queue;

    public void addEmployee(Employee employee) {
        jmsTemplate.convertAndSend(queue, employee);
    }
}
