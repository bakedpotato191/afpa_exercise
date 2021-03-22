package exo;

public class Pompe {
	private String typeCarburant1;
	private int contenance;
	private int contenu;

	public Pompe() {
		super();
		this.typeCarburant1 = "essence";
		this.contenance = 450;
		this.contenu = 235;
	}

	public Pompe(String typeCarburant1, int contenance, int contenu) {
		super();
		this.typeCarburant1 = typeCarburant1;
		this.contenance = contenance;
		this.contenu = contenu;
	}

	public int getContenance() {
		return contenance;
	}

	public void setContenance(int contenance) {
		this.contenance = contenance;
	}

	public int getContenu() {
		return contenu;
	}

	public void setContenu(int contenu) {
		this.contenu = contenu;
	}

	public String getTypeCarburant1() {
		return typeCarburant1;
	}

	public void setTypeCarburant1(String typeCarburant1) {
		this.typeCarburant1 = typeCarburant1;
	}

}
