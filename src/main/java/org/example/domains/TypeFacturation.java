package org.example.domains;

public class TypeFacturation {

    private final String libelle;

    public TypeFacturation(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public static boolean isTypeFacturationIncompatibleVGP(final TypeFacturation typeFacturation) {
        return true;
    }
}
