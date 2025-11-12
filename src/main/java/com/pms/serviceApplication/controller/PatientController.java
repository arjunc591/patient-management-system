package com.pms.serviceApplication.controller;

import com.pms.serviceApplication.contants.PMSContants;
import com.pms.serviceApplication.entity.Patient;
import com.pms.serviceApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PMSContants.BASE_URL)
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(PMSContants.GET_PATIENT)
    public ResponseEntity<List<Patient>> getAllPatient(){
        List<Patient> patientList =  patientService.getAllPatient();
        return ResponseEntity.ok().body(patientList);

    }


}
