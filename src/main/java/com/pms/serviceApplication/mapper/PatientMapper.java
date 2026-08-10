package com.pms.serviceApplication.mapper;

import com.pms.serviceApplication.dto.PatientRequestDto;
import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.entity.Patient;


public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient){
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDateOfBirth(patient.getDateOfBirth());
        patientResponseDto.setRegisteredDate(patient.getRegisteredDate());
        return patientResponseDto;
    }

    public static Patient toEntity(PatientRequestDto requestDto){
        Patient patient = new Patient();
        patient.setName(requestDto.getName());
        patient.setEmail(requestDto.getEmail());
        patient.setAddress(requestDto.getAddress());
        patient.setRegisteredDate(requestDto.getRegisteredDate());
        patient.setDateOfBirth(requestDto.getDateOfBirth());

        return patient;
    }

}
