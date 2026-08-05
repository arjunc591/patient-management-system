package com.pms.serviceApplication.service;

import com.pms.serviceApplication.dto.PatientRequestDto;
import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.entity.Patient;
import com.pms.serviceApplication.mapper.PatientMapper;
import com.pms.serviceApplication.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientRepository patientRepository;
    PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

     public List<PatientResponseDto> getAllPatient(){
         List<Patient> patientList = patientRepository.getAllPatients();
         return patientList.stream().map(patient -> PatientMapper.toDto(patient)).toList();
    }

    public PatientResponseDto savePatient(PatientRequestDto patientRequestDto){
        Patient patient = PatientMapper.toEntity(patientRequestDto);
        return PatientMapper.toDto(patientRepository.savePatient(patient));


    }
}
