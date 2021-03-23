package com.bakedpotato.DAO;

public class Client {
	private static int id = 1;
	private String nom;
	private String prenom;

	public Client(String nom, String prenom) {
		super();
		id++;
		this.nom = nom;
		this.prenom = prenom;
	}

	public static int getId() {
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

}
