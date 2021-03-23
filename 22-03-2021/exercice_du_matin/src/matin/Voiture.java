package matin;

public class Voiture extends Vehicule {

	private final byte nombreRoues = 4;
	private String marque;
	private String model;

	public Voiture(byte nombreRoue, double vitesseMax, double contenanceReservoir, int contenuReservoir, String marque,
			String model) {
		super();
		this.marque = marque;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", model=" + model + ", nombre roues=" + nombreRoues + "]";
	}

}
