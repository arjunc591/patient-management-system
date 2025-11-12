package com.pms.serviceApplication.service;

import com.pms.serviceApplication.entity.Patient;
import com.pms.serviceApplication.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    PatientRepository patientRepository;
    PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

     public List<Patient> getAllPatient(){
        return patientRepository.getAllPatients();
    }
}
