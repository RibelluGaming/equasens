package org.example.domains;

public class Prestation {

    private final String code;
    private final String libelle;

    public Prestation(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }
}
