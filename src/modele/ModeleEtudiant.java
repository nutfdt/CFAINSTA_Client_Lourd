package modele;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Etudiant;

public class ModeleEtudiant {
    private static Bdd uneBdd = new Bdd("localhost", "site_cfa", "root", "");

    public static void insertEtudiant(Etudiant unEtudiant)
    {
        String requete = "insert into etudiant values (null, '"+unEtudiant.getNom()+"','"
                +unEtudiant.getPrenom()+"','"+unEtudiant.getDateNaissance()+"','"
                +unEtudiant.getStatut()+"','"+unEtudiant.getMoyenne()+"','"+unEtudiant.getEmail()+"','"
                +unEtudiant.getMdp()+"','"+unEtudiant.getIdclasse()+"');";

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
    }
    public static ArrayList<Etudiant> selectAllEtudiants()
        {
            String requete = "select * from etudiant;";
            ArrayList<Etudiant> lesEtudiants = new ArrayList<Etudiant>();

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);
            // Parcourir les résultats et construire des objets Techniciens
            while (desResultats.next()) {
                Etudiant unEtudiant = new Etudiant(
                    desResultats.getInt("idetudiant"), desResultats.getInt("idclasse"),
                    desResultats.getFloat("moyenne"), desResultats.getInt("date_naissance"),
                    desResultats.getString("nom"), desResultats.getString("prenom"),
                    desResultats.getString("statut"), desResultats.getString("email"),
                    desResultats.getString("mdp")
                );
                // On ajoute l'instance Technicien dans l'ArrayList
                lesEtudiants.add(unEtudiant);
            }
            
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return lesEtudiants;
    }
        public static void deleteEtudiant(int idetudiant)
        {
            String requete = "delete from etudiant where idetudiant = "+idetudiant+";";

        try     {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);

            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
    }
    public static void updateEtudiant(Etudiant unEtudiant)
    {
        String requete = "update etudiant set nom ='"+unEtudiant.getNom()+"', prenom= '"
                +unEtudiant.getPrenom()+"', date_naissance= '"+unEtudiant.getDateNaissance()+"', statut= '"
                +unEtudiant.getStatut()+"', moyenne= '" +unEtudiant.getMoyenne()+"', email= '"+unEtudiant.getEmail()+"', mdp= '" 
                +unEtudiant.getMdp()+"' where idetudiant =" +unEtudiant.getIdetudiant() + ";" ;

        try     {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
    }
    public static Etudiant selectWhereEtudiant(int idetudiant)
    {
        String requete = "select * from etudiant where idetudiant = "+idetudiant+ ";";
        Etudiant unEtudiant = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                unEtudiant = new Etudiant(
                    unResultat.getInt("idetudiant"), unResultat.getInt("idclasse"),
                    unResultat.getFloat("moyenne"), unResultat.getInt("date_naissance"),
                    unResultat.getString("nom"), unResultat.getString("prenom"),
                    unResultat.getString("statut"), unResultat.getString("email"),
                    unResultat.getString("mdp")
                );
            }       
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return unEtudiant;
    }

    public static Etudiant selectWhereEtudiant(String email, String mdp)
    {
        String requete = "select * from etudiant where email ='"+email+"' and mdp ='"+mdp+"';";
        Etudiant unEtudiant = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                unEtudiant = new Etudiant(
                    unResultat.getInt("idetudiant"), unResultat.getInt("idclasse"),
                    unResultat.getFloat("moyenne"), unResultat.getInt("date_naissance"),
                    unResultat.getString("nom"), unResultat.getString("prenom"),
                    unResultat.getString("statut"), unResultat.getString("email"),
                    unResultat.getString("mdp")
                );
            }       
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return unEtudiant;
    }

}
