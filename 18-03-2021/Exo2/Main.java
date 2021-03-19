package exercice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

		boolean exist;

		for (Specialite i : specialite) {
			System.out.print(i.getNom() + ": ");
			exist = false;
			for (Enseignant j : enseignant) {
				if (i.getId() == (j.getSpecialite().getId())) {
					System.out.print(" " + j);
					exist = true;
				}
			}
			if (!(exist)) {
				System.out.print(" Aucun enseignant pour la spécialité ");
			}
			System.out.println();
		}

		/*
		 * 
		 */

		System.out.println();

		/* Map teachers by speciality */

		ArrayList<String> names = new ArrayList<String>();
		Map<String, String> map = new HashMap<>();

		for (Specialite i : specialite) {
			exist = false;
			for (Enseignant j : enseignant) {
				if (i.getId() == (j.getSpecialite().getId())) {
					names.add(j.toString());
					String a = String.join(",", names);
					map.put(i.getNom(), a);
					exist = true;
				}

			}
			names.clear();
			if (!(exist)) {
				map.put(i.getNom(), " Aucun enseignant pour la spécialité");
			}
		}

		for (Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + " - " + entry.getValue());

	}
}
