package exo2;

import java.util.concurrent.atomic.AtomicInteger;

public class Specialite {
	private static final AtomicInteger count = new AtomicInteger();
	private final int id;
	
	private String specialite;

	public Specialite(String specialite) {
		super();
		this.id = count.getAndIncrement();
		this.specialite = specialite;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Specialite [id=" + id + ", specialite=" + specialite + "]";
	}

}
