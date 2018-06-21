package com.github.nkolytschew.brigitte.service.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BrigitteController {

    // faul sein


    @GetMapping("/hallo")
    public String getResponse(){

        return "Hi, wie kann ich helfen?";

    }


    private BrigitteService service;

    @GetMapping("/ausweis")
    public AusweisFormular getFormular(){

        service.getFormular();

    }


}
