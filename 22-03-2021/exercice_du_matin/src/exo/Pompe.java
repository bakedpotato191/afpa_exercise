package exo;

public class Pompe {
	private final String typeCarburant1 = "essence";
	private short contenance;
	private short contenu;

	public Pompe() {
		super();
		this.contenance = 450;
		this.contenu = 235;
	}

	public Pompe(short contenance, short contenu) {
		super();
		this.contenance = contenance;
		this.contenu = contenu;
	}

	public int getContenance() {
		return contenance;
	}

	public void setContenance(short contenance) {
		this.contenance = contenance;
	}

	public int getContenu() {
		return contenu;
	}

	public void setContenu(byte contenu) {
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
