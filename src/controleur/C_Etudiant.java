package controleur;

import java.util.ArrayList;

import modele.ModeleEtudiant;

public class C_Etudiant {
    public static void insertEtudiant (Etudiant unEtudiant) {
        // On contrôle les données
        ModeleEtudiant.insertEtudiant(unEtudiant);
    }

    public static ArrayList<Etudiant> selectAllEtudiants() {
        return ModeleEtudiant.selectAllEtudiants();
    }

    public static void deleteEtudiant (int idetudiant) {
        ModeleEtudiant.deleteEtudiant(idetudiant);
    }

    public static void updateEtudiant (Etudiant unEtudiant) {
        ModeleEtudiant.updateEtudiant(unEtudiant);
    }

    public static Etudiant selectWhereEtudiant (int idadmin) {
        return ModeleEtudiant.selectWhereEtudiant(idadmin);
    }

    public static Etudiant selectWhereEtudiant (String email, String mdp) {
        return ModeleEtudiant.selectWhereEtudiant(email, mdp);
    }
}
