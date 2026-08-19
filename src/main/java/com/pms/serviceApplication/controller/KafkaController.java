package com.pms.serviceApplication.controller;


import com.pms.serviceApplication.kafka.event.PatientEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kafka")
@RestController
public class KafkaController {

    @Autowired
    PatientEventProducer patientEventProducer;

    @PostMapping("/test")
    public void testKafka(){
        patientEventProducer.testEvent();
    }
}
