package modele;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Classe;

public class ModeleClasse {
    private static Bdd uneBdd = new Bdd("localhost", "orange_250_23", "root", "");

    public static void insertClasse(Classe uneClasse)
    {
        String requete = "insert into classe values (null, '"+uneClasse.getNom()+"','"
                +uneClasse.getnbEleve()+"','"+uneClasse.getSalle()+"', '"+uneClasse.getDiplome()+"');";

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
    public static ArrayList<Classe> selectAllClasses()
        {
            String requete = "select * from classe;";
            ArrayList<Classe> lesClasses = new ArrayList<Classe>();

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);
            // Parcourir les résultats et construire des objets Techniciens
            while (desResultats.next()) {
                Classe uneClasse = new Classe(
                    desResultats.getInt("idclasse"), desResultats.getString("nom"),
                    desResultats.getString("diplome"), desResultats.getInt("salle"),
                    desResultats.getInt("nb_eleve")
                );
                // On ajoute l'instance Technicien dans l'ArrayList
                lesClasses.add(uneClasse);
            }
            
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return lesClasses;
    }
        public static void deleteClasse(int idclasse)
        {
            String requete = "delete from classe where idclasse = "+idclasse+";";

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
    public static void updateClasse(Classe uneClasse)
    {
        String requete = "update classe set nom ='"+uneClasse.getNom()+"', nb_eleve= '"
                +uneClasse.getnbEleve()+"', salle=, '"+uneClasse.getSalle()+"', diplome= '"
                +uneClasse.getDiplome()+"' where idclasse ="
                +uneClasse.getIdclasse() + ";" ;

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
    public static Classe selectWhereClasse(int idclasse)
    {
        String requete = "select * from classe where idclasse = "+idclasse+ ";";
        Classe uneClasse = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                uneClasse = new Classe(
                    unResultat.getInt("idclasse"), unResultat.getString("nom"),
                    unResultat.getString("diplome"), unResultat.getInt("salle"),
                    unResultat.getInt("nb_eleve")
                );
            }       
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return uneClasse;
    }

    public static Classe selectWhereClasse(String nom, String diplome)
    {
        String requete = "select * from classe where nom ='"+nom+"' and diplome ='"+diplome+"';";
        Classe uneClasse = null;

        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            // Tester s'il y a un résultat
            while (unResultat.next()) {
                uneClasse = new Classe(
                    unResultat.getInt("idclasse"), unResultat.getString("nom"),
                    unResultat.getString("diplome"), unResultat.getInt("salle"),
                    unResultat.getInt("nb_eleve")
                );
            }       
            unStat.close();
            uneBdd.seDeconnecter();
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur d'execution de : " + requete);
        }
        return uneClasse;
    }

}
