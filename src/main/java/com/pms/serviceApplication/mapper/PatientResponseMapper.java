package com.pms.serviceApplication.mapper;

import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.entity.Patient;


public class PatientResponseMapper {

    public static PatientResponseDto toDto(Patient patient){
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDate_of_birth(patient.getDate_of_birth());
        patientResponseDto.setRegisteredDate(patient.getRegisteredDate());
        return patientResponseDto;
    }

}
