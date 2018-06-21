package com.github.nkolytschew.renate.service.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RenateService {


    // datenbank im hintergrund

    RestTemplate robert;


    public Formular getFormular(String name){

        // datenbank
//        return getFormularFromDatabaseByName(name);

        String anfrage = "robert/bringsFormular/du/Lauch"

        robert.getForEntity(anfrage, Formular.class);
    }

}
