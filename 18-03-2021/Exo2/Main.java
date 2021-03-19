package exo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {

		ArrayList<Specialite> specialite = new ArrayList<Specialite>();
		ArrayList<Enseignant> enseignant = new ArrayList<Enseignant>();

		specialite.add(new Specialite("JAVA/JEE"));
		specialite.add(new Specialite("HTML/CSS"));
		specialite.add(new Specialite("Gestion de projet"));
		specialite.add(new Specialite("JS"));
		specialite.add(new Specialite("PHP"));

		enseignant.add(new Enseignant("Toutain", "Damien", "damien@gmail.com", specialite.get(0)));
		enseignant.add(new Enseignant("Micheaux", "Francis", "francis@gmail.com", specialite.get(0)));
		enseignant.add(new Enseignant("Souchon", "Bernard", "bernard@gmail.com", specialite.get(4)));
		enseignant.add(new Enseignant("Astier", "Carla", "carla@gmail.com", specialite.get(3)));

		/* Simple output */
		boolean exists;
		for (Specialite i : specialite) {
			System.out.print(i.getNom() + ": ");
			exists = false;
			for (Enseignant j : enseignant) {
				if (i.getId() == (j.getSpecialite().getId())) {
					System.out.print(" " + j);
					exists = true;
				}
			}
			if (!(exists)) {
				System.out.print(" Aucun enseignant pour la spécialité ");
			}
			System.out.println();
		}

		System.out.println();

		/* Map teachers to specialities */
		HashMap<String, String> map = new HashMap<>();

		boolean exist;
		for (Specialite i : specialite) {
			exist = false;
			map.put(i.getNom(), "");
			for (Enseignant j : enseignant) {
				if (i.getNom().equals(j.getSpecialite().getNom())) {
					String existing = map.get(i.getNom()) + " ";
					String extraContent = j.toString();
					map.put(i.getNom(), existing == null ? extraContent : existing + extraContent);
					exist = true;
				}
			}
			if (!(exist)) {
				String existing = map.get(i.getNom()) + " ";
				String extraContent = " Aucun enseignant pour la spécialité";
				map.put(i.getNom(), existing == null ? extraContent : existing + extraContent);
			}
		}

		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}
}
