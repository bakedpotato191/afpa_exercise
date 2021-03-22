package exo;

public class Moto extends Vehicule {

	private byte nombreRoues = 2;
	private String typeCarburant;
	private short maxVitesse;
	private byte contenanceReservoir;
	private byte contenuReservoir;

	public Moto() {
		super();
		nombreRoues = 2;
		typeCarburant = "essence";
		maxVitesse = 140;
	}

	public Moto(byte nombreRoues, String typeCarburant, short maxVitesse, byte contenanceReservoir,
			byte contenuReservoir) {
		super();
		this.nombreRoues = nombreRoues;
		this.typeCarburant = typeCarburant;
		this.maxVitesse = maxVitesse;
		this.contenanceReservoir = contenanceReservoir;
		this.contenuReservoir = contenuReservoir;
	}

	public byte getNombreRoues() {
		return nombreRoues;
	}

	public void setNombreRoues(byte nombreRoues) {
		this.nombreRoues = nombreRoues;
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

	@Override
	public String toString() {
		return "Moto [nombreRoues=" + nombreRoues + ", typeCarburant=" + typeCarburant + ", maxVitesse=" + maxVitesse
				+ ", contenanceReservoir=" + contenanceReservoir + ", contenuReservoir=" + contenuReservoir + "]";
	}

}
