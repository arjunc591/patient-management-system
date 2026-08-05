package com.pms.serviceApplication.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Date;

@Data
public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    @Size(max=100,message = "Enter a valid name")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "enter a valid email id")
    private String email;
    private String address;
    private Date date_of_birth;
    private Date registeredDate;
}
