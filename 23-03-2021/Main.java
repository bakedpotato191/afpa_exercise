package das;

public class Main {

	public static void main(String[] args) {

		Personne[] personnes = new Personne[3];

		personnes[0] = new Personne("Paul", "Random");
		personnes[1] = new Personne("Jean", "Random");
		personnes[2] = new Personne("Adrien", "Random");

		for (int i = 0; i < personnes.length; i++) {
			personnes[i].affiche();
		}
	}

}
