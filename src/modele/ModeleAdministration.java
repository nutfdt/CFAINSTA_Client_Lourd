package modele;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Administration;

public class ModeleAdministration {
    private static Bdd uneBdd = new Bdd("localhost", "orange_250_23", "root", "");

    public static void insertAdministrateur(Administration unAdministrateur)
    {
        String requete = "insert into administration values (null, '"+unAdministrateur.getNom()+"','"
                +unAdministrateur.getPrenom()+"','"+unAdministrateur.getEmail()+"','"
                +unAdministrateur.getMdp()+"');";

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
    public static ArrayList<Administration> selectAllAdministrateurs()
        {
            String requete = "select * from administration;";
            ArrayList<Administration> lesAdministrateurs = new ArrayList<Administration>();

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);
            // Parcourir les résultats et construire des objets Techniciens
            while (desResultats.next()) {
                Administration unAdministrateur = new Administration(
                    desResultats.getInt("idadmin"), desResultats.getString("nom"),
                    desResultats.getString("prenom"), desResultats.getString("email"),
                    desResultats.getString("mdp")
                );
                // On ajoute l'instance Technicien dans l'ArrayList
                lesAdministrateurs.add(unAdministrateur);
            }
            
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return lesAdministrateurs;
    }
        public static void deleteAdministrateur(int idadmin)
        {
            String requete = "delete from administration where idadmin = "+idadmin+";";

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
    public static void updateAdministrateur(Administration unAdministrateur)
    {
        String requete = "update administrateur set nom ='"+unAdministrateur.getNom()+"', prenom= '"
                +unAdministrateur.getPrenom()+"', email= '"+unAdministrateur.getEmail()+"', mdp= '"
                +unAdministrateur.getMdp()+"' where idadmin ="
                +unAdministrateur.getIdadmin() + ";" ;

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
    public static Administration selectWhereAdministrateur(int idadmin)
    {
        String requete = "select * from administration where idadmin = "+idadmin+ ";";
        Administration unAdministrateur = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                unAdministrateur = new Administration(
                    unResultat.getInt("idadmin"), unResultat.getString("nom"),
                    unResultat.getString("prenom"), unResultat.getString("email"),
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
        return unAdministrateur;
    }

    public static Administration selectWhereAdministrateur(String email, String mdp)
    {
        String requete = "select * from administration where email ='"+email+"' and mdp ='"+mdp+"';";
        Administration unAdministrateur = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                unAdministrateur = new Administration(
                    unResultat.getInt("idadmin"), unResultat.getString("nom"),
                    unResultat.getString("prenom"), unResultat.getString("email"),
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
        return unAdministrateur;
    }

}
