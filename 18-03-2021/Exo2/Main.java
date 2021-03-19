package exo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Specialite> specialite = new ArrayList<Specialite>();
		ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
		
		specialite.add(new Specialite ("JAVA/JEE"));
		specialite.add(new Specialite ("HTML/CSS"));
		specialite.add(new Specialite ("Gestion de projet"));
		specialite.add(new Specialite ("JS"));
		specialite.add(new Specialite ("PHP"));
		
		enseignants.add(new Enseignant ("Toutain", "Damien", specialite.get(0)));
		enseignants.add(new Enseignant ("Micheaux", "Francis", specialite.get(0)));
		enseignants.add(new Enseignant ("Souchon", "Bernard", specialite.get(4)));
		enseignants.add(new Enseignant ("Astier", "Carla", specialite.get(3)));
		

		HashMap<String, String> map = new HashMap<>(); 

		boolean exists;
		for (Specialite i : specialite) {
			exists = false;
			map.put(i.getNom(), "");
			for (Enseignant j : enseignants) {
				if (i.getNom().equals(j.getSpecialite().getNom())) {

					String existing = map.get(i.getNom()) + " ";
					String extraContent = "| " + j.getNom() + " " + j.getPrenom();
					map.put(i.getNom(), existing == null ? extraContent : existing + extraContent);
					exists = true;
					
				}
			}
			if (!(exists)) {
				String existing = map.get(i.getNom()) + " ";
				String extraContent = "| No teachers assigned";
				map.put(i.getNom(), existing == null ? extraContent : existing + extraContent);
			}
		}	
		
		for (Entry<String, String> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	
	}
}
