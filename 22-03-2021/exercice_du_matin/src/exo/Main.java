package exo;

public class Main {

	public static void main(String[] args) {

		Voiture v1 = new Voiture("essence", 180, 60, 15);
		Pompe p1 = new Pompe(650, 10);

		Vehicule.fairePlein(p1, v1);
	}
}
