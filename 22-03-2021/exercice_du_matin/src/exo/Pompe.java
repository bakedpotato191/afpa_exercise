package exo;

public class Pompe {
	private final String typeCarburant1 = "essence";
	private int contenance;
	private int contenu;

	public Pompe() {
		super();
		this.contenance = 450;
		this.contenu = 235;
	}

	public Pompe(int contenance, int contenu) {
		super();
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

	@Override
	public String toString() {
		return "Pompe [typeCarburant1=" + typeCarburant1 + ", contenance=" + contenance + ", contenu=" + contenu + "]";
	}
}
