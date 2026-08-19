package com.pms.serviceApplication.kafka.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PatientEventConsumer {

    @KafkaListener(topics = "patient-event", groupId = "pms-consumer-group")
    public void consume(PatientEvent event){
        System.out.println("received patient event "+event);
    }

}
