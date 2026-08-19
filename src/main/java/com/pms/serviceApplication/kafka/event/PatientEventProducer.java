package com.pms.serviceApplication.kafka.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PatientEventProducer {

    private final KafkaTemplate<String, PatientEvent> kafkaTemplate;

    PatientEventProducer(KafkaTemplate<String, PatientEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPatientRegistered(PatientEvent event){
        kafkaTemplate.send("patient-event",event.patientId().toString(),event);
    }

    public void testEvent(){
        PatientEvent event = new PatientEvent(101L,"arjun","arjun@gmail.com");
        publishPatientRegistered(event);
    }


}
