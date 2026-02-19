package com.example.consumer.service;

import com.example.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

   private String message;


    @KafkaListener(topics = "suriya", groupId = "suriya-group")
    public void consume(Employee  employee) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        message = mapper.writeValueAsString(employee);

//        message = employee + "Message got from kafka service: ";
//        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
