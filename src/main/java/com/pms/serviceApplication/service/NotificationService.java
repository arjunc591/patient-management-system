package com.pms.serviceApplication.service;

import com.pms.serviceApplication.kafka.event.PatientEvent;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyPatient(PatientEvent event){
        System.out.println("===============================");
        System.out.println("Hi "+event.name()+" email has been sent to "+event.email());
        System.out.println("Thanks & Regards, Team PMS");
        System.out.println("===============================");
    }
}
