package com.bakedpotato.DAO;

public class Produit {

	private static int id = 1;
	private String nomP;

	public Produit(String nomP) {
		super();
		id++;
		this.nomP = nomP;
	};

	public static int getId() {
		return id;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
}
