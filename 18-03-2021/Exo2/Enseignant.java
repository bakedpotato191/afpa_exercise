package exo2;

import java.util.concurrent.atomic.AtomicInteger;

public class Enseignant{
	
	private static final AtomicInteger count = new AtomicInteger();
	private final int id;
	private String nom;
	private String prenom;
	private Specialite specialite;

	public Enseignant(String nom, String prenom, Specialite specialite) {
		super();
		this.id = count.incrementAndGet();
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Specialite getSpecialite() {
		return this.specialite;
	}
	
	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + "]";
	}
	
}

