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
        patientResponseDto.setDate_of_birth(patient.getDate_of_birth());
        patientResponseDto.setRegisteredDate(patient.getRegisteredDate());
        return patientResponseDto;
    }

    public static Patient toEntity(PatientRequestDto requestDto){
        Patient patient = new Patient();
        patient.setName(requestDto.getName());
        patient.setEmail(requestDto.getEmail());
        patient.setAddress(requestDto.getAddress());
        patient.setRegisteredDate(requestDto.getRegisteredDate());
        patient.setDate_of_birth(requestDto.getDate_of_birth());

        return patient;
    }

}
