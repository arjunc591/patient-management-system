package com.pms.serviceApplication.service;

import com.pms.serviceApplication.dto.PatientRequestDto;
import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.entity.Patient;
import com.pms.serviceApplication.exception.EmailAlreadyExistException;
import com.pms.serviceApplication.exception.PatientNotFoundException;
import com.pms.serviceApplication.kafka.event.PatientEvent;
import com.pms.serviceApplication.kafka.event.PatientEventProducer;
import com.pms.serviceApplication.mapper.PatientMapper;
import com.pms.serviceApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    PatientEventProducer patientEventProducer;
    PatientRepository patientRepository;
    PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

     public List<PatientResponseDto> getAllPatient(){
         List<Patient> patientList = patientRepository.getAllPatients();
         return patientList.stream().map(patient -> PatientMapper.toDto(patient)).toList();
    }

    public PatientResponseDto savePatient(PatientRequestDto patientRequestDto){
        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistException("Email already exist "+patientRequestDto.getEmail());
        }
        Patient patient = PatientMapper.toEntity(patientRequestDto);
        Patient patientResp = patientRepository.savePatient(patient);
        PatientEvent event = new PatientEvent(patientResp.getId(),patientResp.getName(),patientResp.getEmail());
        patientEventProducer.publishPatientEvent(event);

        return PatientMapper.toDto(patientResp);
    }
    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto){
        Patient patient = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("patient not f0und " + patientRequestDto.getName()));
        patient.setName(patientRequestDto.getName());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setDateOfBirth(patientRequestDto.getDateOfBirth());
        return PatientMapper.toDto(patientRepository.saveAndFlush(patient));
    }
}
