package controleur;

public class Administration {
    private int idadmin;
    private String nom, prenom, email, mdp;

    public Administration(int idadmin, String nom, String prenom, String email, String mdp) {
        this.idadmin = idadmin;
        this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
    }

    public Administration(String nom, String prenom, String email, String mdp) {
        this.idadmin = 0;
        this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
    }

    public Administration() {
        this.idadmin = 0;
        this.nom = "";
		this.prenom = "";
		this.email = "";
		this.mdp = "";
    }

    public int getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
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

}
