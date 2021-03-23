package das;

public class Menuisier extends Metier {

	private Personne nom;
	private Personne prenom;

	public Menuisier(Personne nom, Personne prenom, String nomMetier) {
		super(nomMetier);
		this.nom = nom;
		this.prenom = prenom;
		this.nomMetier = nomMetier;
	}

	@Override
	public String toString() {
		return "Menuisier [nomMetier=" + nomMetier + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

}
