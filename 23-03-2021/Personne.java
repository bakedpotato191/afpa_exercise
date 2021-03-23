package das;

public class Personne {
	private String nom;
	private String prenom;
	private Metier nomMetier;

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom, Metier nomMetier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomMetier = nomMetier;
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

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", nomMetier=" + nomMetier + "]";
	}

}
