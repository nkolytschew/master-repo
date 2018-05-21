package com.github.nkolytschew.registrationmonolith.web.rest;


import com.github.nkolytschew.registrationmonolith.service.RegistrationService;
import com.github.nkolytschew.registrationmonolith.web.model.RegistrationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("registration/{id}")
    public ResponseEntity<RegistrationModel> getRegistration(@PathVariable Long id) {
        return new ResponseEntity(this.registrationService.getRegistrationById(id), HttpStatus.OK);
    }

    @PutMapping("registration/{id}")
    public ResponseEntity<RegistrationModel> updateRegistration(@PathVariable Long id, @RequestBody RegistrationModel model) {
        return new ResponseEntity(this.registrationService.updateRegistration(id, model), HttpStatus.OK);
    }

    @PostMapping("registration")
    public ResponseEntity<RegistrationModel> createRegistration(@RequestBody RegistrationModel model) {
        return new ResponseEntity(this.registrationService.createRegistration(model), HttpStatus.OK);
    }

    @DeleteMapping("registration/{id}")
    public ResponseEntity<RegistrationModel> deleteRegistration(@PathVariable Long id) {
        return new ResponseEntity(this.registrationService.deleteRegistration(id), HttpStatus.OK);
    }

    @GetMapping("registrations")
    public ResponseEntity<List<RegistrationModel>> getRegistrations() {
        return new ResponseEntity(this.registrationService.getAllRegistrations(), HttpStatus.OK);
    }
}