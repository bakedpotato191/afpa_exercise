package exo2;

import java.util.concurrent.atomic.AtomicInteger;

public class Specialite {
	private static final AtomicInteger count = new AtomicInteger();
	private final int id;
	
	private String nom;

	public Specialite(String nom) {
		super();
		this.id = count.getAndIncrement();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Specialite [id=" + id + ", specialite=" + nom + "]";
	}

}
