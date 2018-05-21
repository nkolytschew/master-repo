package com.github.nkolytschew.registrationservice.rest;


import com.github.nkolytschew.registrationservice.rest.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
public class RegistrationController {


    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping("registrations")
    public Map<String, String> getRegistrations() {
        return this.registrationService.findRegistrations();
    }

    @GetMapping("registration/{id}")
    public String getRegistrationById(@PathVariable String id) {
        return this.registrationService.findRegistrationById(id);
    }

    @PostMapping("registration/{id}")
    public String saveRegistration(@PathVariable String id,
                                   @RequestBody String value) {
        return this.registrationService.saveRegistrationById(id, value);
    }

    @DeleteMapping("registration/{id}")
    public String deleteRegistration(@PathVariable String id) {
        return this.registrationService.deleteRegistrationById(id);
    }

}
