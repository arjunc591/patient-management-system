package com.pms.serviceApplication.entity;

import jakarta.persistence.Entity;
import jdk.jfr.DataAmount;

import java.sql.Date;


@Entity

public class Patient {

    private String name;
    private String email;
    private String address;
    private Date dob;
    private Date registeredDate;


}
