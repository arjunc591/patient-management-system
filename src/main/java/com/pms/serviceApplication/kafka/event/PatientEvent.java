package com.pms.serviceApplication.kafka.event;

public record PatientEvent(
        Long patientId,
        String name,
        String email
) {
}
