package com.pms.serviceApplication.kafka.event;

import com.pms.serviceApplication.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PatientEventConsumer {

    @Autowired
    NotificationService notificationService;

    @KafkaListener(topics = "patient-event", groupId = "notification-consumer-group")
    public void consume(PatientEvent event){
        notificationService.notifyPatient(event);
    }

}
