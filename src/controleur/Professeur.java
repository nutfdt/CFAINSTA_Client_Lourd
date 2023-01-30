package controleur;

public class Professeur {
    private int idprofesseur;
    private String nom, prenom, email, specialite, mdp;

    public Professeur(int idprofesseur, String nom, String prenom, String email, String specialite, String mdp) {
        this.idprofesseur = idprofesseur;
        this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.specialite = specialite;
        this.mdp = mdp;
    }

    public Professeur(String nom, String prenom, String email, String specialite, String mdp) {
        this.idprofesseur = 0;
        this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.specialite = specialite;
        this.mdp = mdp;
    }

    public Professeur() {
        this.idprofesseur = 0;
        this.nom = "";
		this.prenom = "";
		this.email = "";
		this.specialite = "";
        this.mdp = "";
    }

    public int getIdprofesseur() {
		return idprofesseur;
	}

	public void setIdprofesseur(int idprofesseur) {
		this.idprofesseur = idprofesseur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}


	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
