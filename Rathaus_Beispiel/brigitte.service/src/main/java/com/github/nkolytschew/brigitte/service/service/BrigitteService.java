package com.github.nkolytschew.brigitte.service.service;


import org.springframework.stereotype.Service;

@Service
public class BrigitteService {


    // brigitte sitzt aber am schalter

    RestTemplate renate;

    public AusweisFormular getFormular(){

        // gegen Datenbank
        // rufe renate, damit sie das formular bringt

        String anfragePunktFuerFornmular = "renate/hol/formular";
       AusweisFormular formular =  renate.getForObject(anfragePunktFuerFornmular, AusweisFormular.class);

       AusweisFormuar vorbefüllt = this.vorauswahlBefuellen(formular);

       return vorbefüllt;
    }

    public AusweisFormular vorauswahlBefuellen(Ausweisformular formular){
        // fülle aus


        return formular;
    }


}
