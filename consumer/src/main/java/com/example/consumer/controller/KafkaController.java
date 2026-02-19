package com.example.consumer.controller;

import com.example.consumer.entity.Employee;
import com.example.consumer.service.KafkaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private KafkaService kafkaService;
    KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }
    @GetMapping("/get")
    public ResponseEntity<String> getemployee() {
        String emp = kafkaService.getMessage();
        return ResponseEntity.ok(emp);
    }
}
