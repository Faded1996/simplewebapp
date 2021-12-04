package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ActiveMQEmployeeProducer {

    private JmsTemplate jmsTemplate;

    @Value("${activemq.queue-name}")
    private String queueName;

    public void addEmployee(final Employee employee) {
        jmsTemplate.convertAndSend(queueName, employee);
    }
}
