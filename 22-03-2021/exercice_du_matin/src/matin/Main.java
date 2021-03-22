package matin;

public class Main {

	public static void main(String[] args) {

		Voiture v1 = new Voiture("essence", 180, 60, 15);
		Pompe p1 = new Pompe((short) 650, (short) 250);

		Voiture.fairePlein(p1, v1);
	}
}
