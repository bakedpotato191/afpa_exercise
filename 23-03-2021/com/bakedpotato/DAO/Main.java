package com.bakedpotato.DAO;

public class Main {

	public static void main(String[] args) {

		ClientDAO zook = new ClientDAO();

		zook.create(new Client("Zeke", "Yeager"));

	}

}