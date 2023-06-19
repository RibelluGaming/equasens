package org.example.service;

import org.example.applets.AppletFacturation;
import org.example.applets.AtissApplet;
import org.example.domains.DonneesFacturation;
import org.example.domains.Prestation;
import org.example.domains.TypeFacturation;
import org.example.processus.OperateurDPCProcessus;
import org.example.utils.IPrestationConstantes;
import org.example.utils.UtilDialog;

import javax.swing.*;

public class FacturationService {

    private final OperateurDPCProcessus operateurDpcProcessus = new OperateurDPCProcessus();
    private final AtissApplet parentApplet = new AppletFacturation();
    DonneesFacturation df = new DonneesFacturation();

    public boolean ajouterLigne(Prestation prest, final TypeFacturation tf) {
        if (operateurDpcProcessus.rechercherOperateursDPC().isEmpty()) {
            UtilDialog.afficheMsgErreur(parentApplet, "Aucun opérateur n'est autorisé à vacciner.\n"
                    + "Vous pouvez renseigner ces informations dans le module de gestion des opérateurs.");
            return false;
        }

        if (!typeFacturationCompatibleVGP(prest, tf)) {
            return false;
        }

        if (df.getTheAssureAyantDroit() == null) {
            UtilDialog.afficheMsgErreur(parentApplet,
                    "Ajout d'un acte de vaccination pour lequel la saisie d'un patient est obligatoire.\n"
                            + "Veuillez compléter l'information nécessaire à la saisie d'un acte de vaccination.");
            if (parentApplet instanceof AppletFacturation) {
                SwingUtilities.invokeLater(() -> ((AppletFacturation) parentApplet).pAssure.requestFocus());
            }
            return false;
        }

        /*
         * ...
         * ...
         * ...
         */

        return true;
    }

    private boolean typeFacturationCompatibleVGP(final Prestation prestation, final TypeFacturation typeFacturation) {
        if (IPrestationConstantes.PRESTATION_VGP.equals(prestation.getCode())
                && TypeFacturation.isTypeFacturationIncompatibleVGP(typeFacturation)) {
            UtilDialog.afficheMsgErreur(parentApplet,
                    "La prestation " + prestation.getCode() + " " + prestation.getLibelle()
                            + " est incompatible avec une ligne \"" + typeFacturation.getLibelle() + "\".");
            return false;
        } else {
            return true;
        }
    }
}
