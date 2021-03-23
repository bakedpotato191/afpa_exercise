package matin;

public class Vehicule {

	protected String typeCarburant;
	private int contenanceReservoir;
	private double contenuReservoir;
	private int vitesseMax;
	private int nombreRoue;

	public String getTypeCarburant() {
		return typeCarburant;
	}

	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}

	public int getContenanceReservoir() {
		return contenanceReservoir;
	}

	public void setContenanceReservoir(int contenanceReservoir) {
		this.contenanceReservoir = contenanceReservoir;
	}

	public double getContenuReservoir() {
		return contenuReservoir;
	}

	public void setContenuReservoir(double contenuReservoir) {
		this.contenuReservoir = contenuReservoir;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public int getNombreRoue() {
		return nombreRoue;
	}

	public void setNombreRoue(int nombreRoue) {
		this.nombreRoue = nombreRoue;
	}

	public void fairePlein(Pompe p1) {
		System.out.println("J'arrive à la pompe");
		if (this.typeCarburant == p1.getTypeCarburant()) {

			double besoinEnCarburant = this.contenanceReservoir - this.contenuReservoir;
			System.out.println("J'ai besoin de \n\t ==>" + besoinEnCarburant + " litre(s)");
			if (besoinEnCarburant > p1.getContenu()) {
				besoinEnCarburant = p1.getContenu();
			}
			System.out.println("Faire le plein en ajoutant au contenu ce que j'ai besoin pour remplir");
			this.contenuReservoir += besoinEnCarburant;
			double nouveauContenuPompe = p1.getContenu() - besoinEnCarburant;
			p1.setContenu(nouveauContenuPompe);

		} else {
			System.out.println("Je vais changer de pompe ...");
		}
	}
}
