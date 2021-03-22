package exo;

public class Voiture extends Vehicule {

	private final int nombreRoues = 4;
	private String typeCarburant;
	private int maxVitesse;
	private int contenanceReservoir;
	private int contenuReservoir;

	public Voiture() {
		super();
		this.typeCarburant = "diesel";
		this.maxVitesse = 200;
		this.contenanceReservoir = 60;
		this.contenuReservoir = 35;
	}

	public Voiture(String typeCarburant, int maxVitesse, int contenanceReservoir, int contenuReservoir) {
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

	public int getMaxVitesse() {
		return maxVitesse;
	}

	public void setMaxVitesse(int maxVitesse) {
		this.maxVitesse = maxVitesse;
	}

	public int getContenanceReservoir() {
		return contenanceReservoir;
	}

	public void setContenanceReservoir(int contenanceReservoir) {
		this.contenanceReservoir = contenanceReservoir;
	}

	public int getContenuReservoir() {
		return contenuReservoir;
	}

	public void setContenuReservoir(int contenuReservoir) {
		this.contenuReservoir = contenuReservoir;
	}

	public int getNombreRoues() {
		return nombreRoues;
	}

	@Override
	public String toString() {
		return "Voiture [nombreRoues=" + nombreRoues + ", typeCarburant=" + typeCarburant + ", maxVitesse=" + maxVitesse
				+ ", contenanceReservoir=" + contenanceReservoir + ", contenuReservoir=" + contenuReservoir + "]";
	}

}
