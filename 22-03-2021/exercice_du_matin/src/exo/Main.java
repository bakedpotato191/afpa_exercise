package exo;

public class Main {

	public static void main(String[] args) {

		Voiture v1 = new Voiture(4, "essence", 180, 60, 15);
		Pompe p1 = new Pompe("essence", 650, 85);

		Vehicule.fairePlein(p1, v1);
	}

}
