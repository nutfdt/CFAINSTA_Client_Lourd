package modele;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Professeur;

public class ModeleProfesseur {
    private static Bdd uneBdd = new Bdd("localhost", "site_cfa", "root", "");

    public static void insertProfesseur(Professeur unProfesseur)
    {
        String requete = "insert into professeur values (null, '"+unProfesseur.getNom()+"','"
                +unProfesseur.getPrenom()+"','"+unProfesseur.getEmail()+"', '"+unProfesseur.getSpecialite()+"', '"
                +unProfesseur.getMdp()+"');";

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
    public static ArrayList<Professeur> selectAllProfesseurs()
        {
            String requete = "select * from professeur;";
            ArrayList<Professeur> lesProfesseurs = new ArrayList<Professeur>();

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);
            // Parcourir les résultats et construire des objets Techniciens
            while (desResultats.next()) {
                Professeur unProfesseur = new Professeur(
                    desResultats.getInt("idprofesseur"), desResultats.getString("nom"),
                    desResultats.getString("prenom"), desResultats.getString("email"),
                    desResultats.getString("specialite"), desResultats.getString("mdp")
                );
                // On ajoute l'instance Technicien dans l'ArrayList
                lesProfesseurs.add(unProfesseur);
            }
            
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return lesProfesseurs;
    }
        public static void deleteProfesseur(int idprofesseur)
        {
            String requete = "delete from professeur where idprofesseur = "+idprofesseur+";";

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
    public static void updateProfesseur(Professeur unProfesseur)
    {
        String requete = "update professeur set nom ='"+unProfesseur.getNom()+"', prenom= '"
                +unProfesseur.getPrenom()+"', email=, '"+unProfesseur.getEmail()+"', specialite= '"
                +unProfesseur.getSpecialite()+"', mdp= '" +unProfesseur.getMdp()+"' where idprofesseur ="
                +unProfesseur.getIdprofesseur() + ";" ;

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
    public static Professeur selectWhereProfesseur(int idprofesseur)
    {
        String requete = "select * from professeur where idprofesseur = "+idprofesseur+ ";";
        Professeur unProfesseur = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                unProfesseur = new Professeur(
                    unResultat.getInt("idprofesseur"), unResultat.getString("nom"),
                    unResultat.getString("prenom"), unResultat.getString("email"),
                    unResultat.getString("specialite"), unResultat.getString("mdp")
                );
            }       
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return unProfesseur;
    }

    public static Professeur selectWhereProfesseur(String email, String mdp)
    {
        String requete = "select * from professeur where email ='"+email+"' and mdp ='"+mdp+"';";
        Professeur unProfesseur = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                unProfesseur = new Professeur(
                    unResultat.getInt("idprofesseur"), unResultat.getString("nom"),
                    unResultat.getString("prenom"), unResultat.getString("email"),
                    unResultat.getString("specialite"), unResultat.getString("mdp")
                );
            }       
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return unProfesseur;
    }

}
