package com.github.nkolytschew.registrationservice.rest.service;

import java.util.Map;

public interface RegistrationService {

    Map<String, String> findRegistrations();

    String findRegistrationById(String id);

    String deleteRegistrationById(String id);

    String saveRegistrationById(String id, String value);

}
