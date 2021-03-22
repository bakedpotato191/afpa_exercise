package matin;

public class Main {

	public static void main(String[] args) {

		Voiture v1 = new Voiture("essence", (short) 180, (byte) 60, (byte) 15);
		Pompe p1 = new Pompe((short) 650, (short) 250);

		Voiture.fairePlein(p1, v1);
	}
}
