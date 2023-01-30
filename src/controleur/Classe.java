package controleur;

public class Classe {
    private int idclasse, salle, nb_eleve;
    private String nom, diplome;

    public Classe(int idclasse, String diplome, String nom, int salle, int nb_eleve) {
        this.idclasse = idclasse;
        this.nom = nom;
		this.diplome = diplome;
		this.salle = salle;
		this.nb_eleve = nb_eleve;
    }

    public Classe(String nom, String diplome, int salle, int nb_eleve) {
        this.idclasse = 0;
        this.nom = nom;
		this.diplome = diplome;
		this.salle = 0;
		this.nb_eleve = 0;
    }

    public Classe() {
        this.idclasse = 0;
        this.nom = "";
		this.diplome = "";
		this.salle = 0;
		this.nb_eleve = 0;
    }

    public int getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public int getnbEleve() {
		return nb_eleve;
	}

	public void setnbEleve(int nb_eleve) {
		this.nb_eleve = nb_eleve;
	}

}
