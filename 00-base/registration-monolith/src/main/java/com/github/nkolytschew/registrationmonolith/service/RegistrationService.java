package com.github.nkolytschew.registrationmonolith.service;


import com.github.nkolytschew.registrationmonolith.web.model.RegistrationModel;

import java.util.List;

public interface RegistrationService {

    RegistrationModel getRegistrationById(Long id);

    RegistrationModel updateRegistration(Long id, RegistrationModel model);

    RegistrationModel createRegistration(RegistrationModel model);

    RegistrationModel deleteRegistration(Long id);

    List<RegistrationModel> getAllRegistrations();
}
