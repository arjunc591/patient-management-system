package com.pms.serviceApplication.controller;

import com.pms.serviceApplication.contants.PMSContants;
import com.pms.serviceApplication.dto.PatientRequestDto;
import com.pms.serviceApplication.dto.PatientResponseDto;
import com.pms.serviceApplication.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(PMSContants.BASE_URL)
@Tag(name = "patient controller",description = "patient crud operations")
public class PatientController {

    private static final Logger log = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    PatientService patientService;

    @GetMapping(PMSContants.GET_PATIENT)
    @Operation(description = "fetch patient details")
    public ResponseEntity<List<PatientResponseDto>> getAllPatient(){
        List<PatientResponseDto> patientList =  patientService.getAllPatient();
        log.info(patientList.toString());
        return ResponseEntity.ok().body(patientList);

    }

    @PostMapping(PMSContants.CREATE_PATIENT)
    @Operation(description = "create a new patient")
    public ResponseEntity<PatientResponseDto> savePatient(@Valid @RequestBody PatientRequestDto request){
        return ResponseEntity.ok().body(patientService.savePatient(request));
    }

    @PutMapping(PMSContants.UPDATE_PATIENT+"/{id}")
    @Operation(description = "update patient details")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable UUID id,@RequestBody PatientRequestDto patientRequestDto){
       return ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDto));
    }


}
