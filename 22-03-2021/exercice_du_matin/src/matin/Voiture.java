package matin;

public class Voiture extends Vehicule {

	private final byte nombreRoues = 4;
	private String typeCarburant;
	private short maxVitesse;
	private byte contenanceReservoir;
	private byte contenuReservoir;

	public Voiture() {
		super();
		this.typeCarburant = "diesel";
		this.maxVitesse = 200;
		this.contenanceReservoir = 60;
		this.contenuReservoir = 35;
	}

	public Voiture(String typeCarburant, short maxVitesse, byte contenanceReservoir, byte contenuReservoir) {
		super();
		this.typeCarburant = typeCarburant;
		this.maxVitesse = maxVitesse;
		this.contenanceReservoir = contenanceReservoir;
		this.contenuReservoir = contenuReservoir;
	}

	public String getTypeCarburant() {
		return typeCarburant;
	}

	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}

	public short getMaxVitesse() {
		return maxVitesse;
	}

	public void setMaxVitesse(short maxVitesse) {
		this.maxVitesse = maxVitesse;
	}

	public byte getContenanceReservoir() {
		return contenanceReservoir;
	}

	public void setContenanceReservoir(byte contenanceReservoir) {
		this.contenanceReservoir = contenanceReservoir;
	}

	public byte getContenuReservoir() {
		return contenuReservoir;
	}

	public void setContenuReservoir(byte contenuReservoir) {
		this.contenuReservoir = contenuReservoir;
	}

	public byte getNombreRoues() {
		return nombreRoues;
	}

	@Override
	public String toString() {
		return "Voiture [nombreRoues=" + nombreRoues + ", typeCarburant=" + typeCarburant + ", maxVitesse=" + maxVitesse
				+ ", contenanceReservoir=" + contenanceReservoir + ", contenuReservoir=" + contenuReservoir + "]";
	}

}
