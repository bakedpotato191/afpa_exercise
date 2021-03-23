package matin;

public class Pompe {
	private String typeCarburant;
	private short contenance;
	private double contenu;

	public Pompe() {
		super();
	}

	public Pompe(String typeCarburant, short contenance, double contenu) {
		super();
		this.typeCarburant = typeCarburant;
		this.contenance = contenance;
		this.contenu = contenu;
	}

	public String getTypeCarburant() {
		return typeCarburant;
	}

	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}

	public short getContenance() {
		return contenance;
	}

	public void setContenance(short contenance) {
		this.contenance = contenance;
	}

	public double getContenu() {
		return contenu;
	}

	public void setContenu(double nouveauContenuPompe) {
		this.contenu = nouveauContenuPompe;
	}

	@Override
	public String toString() {
		return "Pompe [typeCarburant=" + typeCarburant + ", contenance=" + contenance + ", contenu=" + contenu + "]";
	}

}
