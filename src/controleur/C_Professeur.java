package controleur;

import java.util.ArrayList;

import modele.ModeleProfesseur;

public class C_Professeur {
    public static void insertProfesseur (Professeur unProfesseur) {
        // On contrôle les données
        ModeleProfesseur.insertProfesseur(unProfesseur);
    }

    public static ArrayList<Professeur> selectAllProfesseurs() {
        return ModeleProfesseur.selectAllProfesseurs();
    }

    public static void deleteProfesseur (int idprofesseur) {
        ModeleProfesseur.deleteProfesseur(idprofesseur);
    }

    public static void updateProfesseur (Professeur unProfesseur) {
        ModeleProfesseur.updateProfesseur(unProfesseur);
    }

    public static Professeur selectWhereProfesseur (int idprofesseur) {
        return ModeleProfesseur.selectWhereProfesseur(idprofesseur);
    }

    public static Professeur selectWhereProfesseur (String email, String mdp) {
        return ModeleProfesseur.selectWhereProfesseur(email, mdp);
    }
}
