package com.pms.serviceApplication.controller;

import com.pms.serviceApplication.contants.PMSContants;
import com.pms.serviceApplication.dto.PatientRequestDto;
import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.service.PatientService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public ResponseEntity<PatientResponseDto> savePatient(@Valid @RequestBody PatientRequestDto request){
        return ResponseEntity.ok().body(patientService.savePatient(request));
    }


}
