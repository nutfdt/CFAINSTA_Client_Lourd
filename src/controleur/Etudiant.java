package controleur;


public class Etudiant {
    private int idetudiant, idclasse, date_naissance;
    private float moyenne;
    private String nom, prenom, statut, email, mdp;

    public Etudiant(int idetudiant, int idclasse, float moyenne, int date_naissance, String nom, String prenom, String statut, String email, String mdp) {
        this.idetudiant = idetudiant;
        this.idclasse = idclasse;
        this.moyenne = moyenne;
        this.date_naissance = date_naissance;
        this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.email = email;
        this.mdp = mdp;
    }

    public Etudiant(int idclasse, float moyenne, int date_naissance, String nom, String prenom, String statut, String email, String mdp) {
        this.idetudiant = 0;
        this.idclasse = 0;
        this.moyenne = 0;
        this.date_naissance = 0;
        this.nom = nom;
		this.prenom = prenom;
		this.statut = statut;
		this.email = email;
        this.mdp = mdp;
    }

    public Etudiant() {
        this.idetudiant = 0;
        this.idclasse = 0;
        this.moyenne = 0;
        this.date_naissance = 0;
        this.nom = "";
		this.prenom = "";
		this.statut = "";
		this.email = "";
        this.mdp = "";
    }

    public int getIdetudiant() {
		return idetudiant;
	}

	public void setIdetudiant(int idetudiant) {
		this.idetudiant = idetudiant;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getIdclasse() {
		return idclasse;
	}

	public void setIdclasse(int idclasse) {
		this.idclasse = idclasse;
	}

	public int getDateNaissance() {
		return date_naissance;
	}

	public void setDateNaissance(int date_naissance) {
		this.date_naissance = date_naissance;
	}

	public float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}

}
