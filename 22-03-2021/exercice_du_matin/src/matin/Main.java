package matin;

public class Main {

	public static void main(String[] args) {

		Voiture clio = new Voiture((byte) 4, 270.5, 180, 50, "Renault", "Clio");
		Pompe p1 = new Pompe("Essence", (short) 650, (float) 125.5);

		clio.setTypeCarburant("Essence");
		clio.setContenanceReservoir(65);
		clio.setContenuReservoir(12.5);
		clio.fairePlein(p1);

		System.out.println(clio.toString());
	}
}
