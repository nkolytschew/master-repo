package com.github.nkolytschew.renate.service.mvc;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenateController {

    // nix tun



    RenateService service;

    // renate/hol/formular
    @GetMapping("hol/formular")
    public AusweisFormular getFormular(){

//        return "kenn ich nicht";
//        return "habe gerade pause";

        return service.getFormular("ausweis");
    }

}
