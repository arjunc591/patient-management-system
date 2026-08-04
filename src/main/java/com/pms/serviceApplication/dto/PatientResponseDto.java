package com.pms.serviceApplication.dto;

import lombok.Data;
import java.sql.Date;


@Data
public class PatientResponseDto {
    private String name;
    private String email;
    private String address;
    private Date date_of_birth;
    private Date registeredDate;
}
