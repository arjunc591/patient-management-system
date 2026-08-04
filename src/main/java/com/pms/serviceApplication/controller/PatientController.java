package com.pms.serviceApplication.controller;

import com.pms.serviceApplication.contants.PMSContants;
import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.entity.Patient;
import com.pms.serviceApplication.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(PMSContants.BASE_URL)

public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    PatientService patientService;

    @GetMapping(PMSContants.GET_PATIENT)
    public ResponseEntity<List<PatientResponseDto>> getAllPatient(){
        List<PatientResponseDto> patientList =  patientService.getAllPatient();
        log.info(patientList.toString());
        return ResponseEntity.ok().body(patientList);

    }


}
