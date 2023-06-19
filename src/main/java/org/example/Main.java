package org.example;

import org.example.domains.Prestation;
import org.example.domains.TypeFacturation;
import org.example.service.FacturationService;

public class Main {

    public static void main(String[] args) {
        Prestation prest = new Prestation( "codePrestation", "libellePrestation");
        TypeFacturation tf = new TypeFacturation("libelleTypeFacturation");
        FacturationService facturationService = new FacturationService();
        boolean ajoutLigne = facturationService.ajouterLigne(prest, tf);
    }


}