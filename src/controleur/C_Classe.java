package controleur;

import java.util.ArrayList;

import modele.ModeleClasse;

public class C_Classe {
    public static void insertClasse (Classe uneClasse) {
        // On contrôle les données
        ModeleClasse.insertClasse(uneClasse);
    }

    public static ArrayList<Classe> selectAllClasses() {
        return ModeleClasse.selectAllClasses();
    }

    public static void deleteClasse (int idclasse) {
        ModeleClasse.deleteClasse(idclasse);
    }

    public static void updateClasse (Classe uneClasse) {
        ModeleClasse.updateClasse(uneClasse);
    }

    public static Classe selectWhereClasse (int idclasse) {
        return ModeleClasse.selectWhereClasse(idclasse);
    }

    public static Classe selectWhereClass (String nom, String diplome) {
        return ModeleClasse.selectWhereClasse(nom, diplome);
    }
}
