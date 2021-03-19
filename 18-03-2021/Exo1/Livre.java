package exo1;

import java.util.concurrent.atomic.AtomicInteger;

public class Livre {
	
	private static final AtomicInteger count = new AtomicInteger();
	private final int id;
	private String titre;
	private String auteur;
	private double prix;
	
	public Livre() {
		super();
		/* les valeurs par default */
		this.id = count.incrementAndGet();
		this.titre = "Cool le Java";
		this.auteur = "Afpa";
		this.prix = 99.99;
	}

	public Livre(String titre, String auteur, double prix) {
		super();
		this.id = count.incrementAndGet();
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
	}

	public final int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return id + " | " + titre + " | " + auteur + " | " + prix;
	}

}
