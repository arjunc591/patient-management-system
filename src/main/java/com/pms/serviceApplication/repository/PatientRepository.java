package com.pms.serviceApplication.repository;

import com.pms.serviceApplication.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    default List<Patient> getAllPatients(){
        return findAll();
    }
}
