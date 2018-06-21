package com.github.nkolytschew.robert.service.mvc;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobertController {

    @GetMapping("bringsFormular/du/Lauch")
    public Formular getFormular(){
        // hole formular von datenbnank
        Formular formular = ...;

        return formular;
    }
}
