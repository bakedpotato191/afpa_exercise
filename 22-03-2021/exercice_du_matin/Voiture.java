package exo;

public class Voiture extends Vehicule {

	private int nombreRoues = 4;
	private String typeCarburant;
	private int maxVitesse;
	private int contenanceReservoir;
	private int contenuReservoir;

	public Voiture() {
		super();
		nombreRoues = 4;
		typeCarburant = "diesel";
		maxVitesse = 200;
	}

	public Voiture(int nombreRoues, String typeCarburant, int maxVitesse, int contenanceReservoir,
			int contenuReservoir) {
		super();
		this.nombreRoues = nombreRoues;
		this.typeCarburant = typeCarburant;
		this.maxVitesse = maxVitesse;
		this.contenanceReservoir = contenanceReservoir;
		this.contenuReservoir = contenuReservoir;
	}

	public int getNombreRoues() {
		return nombreRoues;
	}

	public void setNombreRoues(int nombreRoues) {
		this.nombreRoues = nombreRoues;
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

	@Override
	public String toString() {
		return "Voiture [nombreRoues=" + nombreRoues + ", typeCarburant=" + typeCarburant + ", maxVitesse=" + maxVitesse
				+ ", contenanceReservoir=" + contenanceReservoir + ", contenuReservoir=" + contenuReservoir + "]";
	}

}
