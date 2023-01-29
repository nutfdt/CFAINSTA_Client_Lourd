package controleur;

import java.util.ArrayList;

import modele.ModeleAdministration;

public class C_Administration {
    public static void insertAdmin (Administration unAdministrateur) {
        // On contrôle les données
        ModeleAdministration.insertAdministrateur(unAdministrateur);
    }

    public static ArrayList<Administration> selectAllAdministrateurs() {
        return ModeleAdministration.selectAllAdministrateurs();
    }

    public static void deleteAdministrateur (int idadmin) {
        ModeleAdministration.deleteAdministrateur(idadmin);
    }

    public static void updateAdministrateur (Administration unAdministrateur) {
        ModeleAdministration.updateAdministrateur(unAdministrateur);
    }

    public static Administration selectWhereAdministrateur (int idadmin) {
        return ModeleAdministration.selectWhereAdministrateur(idadmin);
    }

    public static Administration selectWhereAdministrateur (String email, String mdp) {
        return ModeleAdministration.selectWhereAdministrateur(email, mdp);
    }
}
