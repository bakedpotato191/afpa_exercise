package matin;

public class Moto extends Vehicule {

	private final byte nombreRoues = 2;
	private String marque;
	private String model;

	public Moto(byte nombreRoue, double vitesseMax, double contenanceReservoir, int contenuReservoir, String marque,
			String model) {
		super();
		this.marque = marque;
		this.model = model;
	}

	@Override
	public String toString() {
		return "Moto [marque=" + marque + ", model=" + model + ", nombre roues=" + nombreRoues + "]";
	}

}
