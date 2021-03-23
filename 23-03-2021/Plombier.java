package das;

public class Plombier extends Metier {

	private Personne nom;
	private Personne prenom;

	public Plombier(String nomMetier, Personne nom, Personne prenom) {
		super(nomMetier);
		this.nom = nom;
		this.prenom = prenom;
		this.nomMetier = nomMetier;
	}

	@Override
	public String toString() {
		return "Plombier [nomMetier=" + nomMetier + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
}
