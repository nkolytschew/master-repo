package com.github.nkolytschew.registrationmonolith.web.model;


import lombok.Data;

@Data
public class RegistrationModel {
    // registration
    private String registrationName;
    private String registrationDescription;

    // person
    private String userName;
    private String address;
}
