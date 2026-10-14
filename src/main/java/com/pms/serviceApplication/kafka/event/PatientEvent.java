package com.pms.serviceApplication.kafka.event;

import java.util.UUID;

public record PatientEvent(
        UUID patientId,
        String name,
        String email
) {
}
