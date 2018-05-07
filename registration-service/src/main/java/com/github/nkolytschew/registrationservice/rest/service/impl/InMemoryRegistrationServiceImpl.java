package com.github.nkolytschew.registrationservice.rest.service.impl;

import com.github.nkolytschew.registrationservice.rest.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class InMemoryRegistrationServiceImpl implements RegistrationService {


    private Map<String, String> responseList;

    public InMemoryRegistrationServiceImpl() {
        this.responseList = new HashMap<>();
        this.responseList.put("1", "Klaus");
        this.responseList.put("2", "Nicht Klaus");
        this.responseList.put("3", "Max");
        this.responseList.put("4", "Muster");
        this.responseList.put("5", "Seb");
        this.responseList.put("6", "Otto");
        this.responseList.put("7", "Horst");
        this.responseList.put("8", "Hans");
        this.responseList.put("9", "Dieter");
    }

    @Override
    public Map<String, String> findRegistrations() {
        return this.responseList;
    }

    @Override
    public String findRegistrationById(String id) {
        return this.responseList.get(id);
    }

    @Override
    public String deleteRegistrationById(String id) {
        return this.responseList.remove(id);
    }

    @Override
    public String saveRegistrationById(String id, String value) {
        return this.responseList.put(id, value);
    }
}

class Registration{
    private String id;
    private String name;
}