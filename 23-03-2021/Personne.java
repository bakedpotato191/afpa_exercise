package das;

public class Personne {
	private String nom;
	private String prenom;

	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
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

	public void affiche() {
		System.out.println("Personne [nom=" + nom + ", prenom=" + prenom + "]");
	}

}
