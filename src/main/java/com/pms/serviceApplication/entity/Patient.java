package com.pms.serviceApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;
import java.util.UUID;


@Entity
public class Patient {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String address;
    private Date dob;
    private Date registeredDate;


}
