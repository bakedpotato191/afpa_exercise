package exo;

public class Vehicule {
	private static int toFill;

	public static void fairePlein(Pompe obj1, Voiture obj2) {
		if (obj1.getTypeCarburant1().equals(obj2.getTypeCarburant())) {
			if (obj1.getContenu() > (obj2.getContenanceReservoir() - obj2.getContenuReservoir())) {
				toFill = obj2.getContenanceReservoir() - obj2.getContenuReservoir();

				affiche_info_avant_remplissage(toFill, obj1.getContenu(), obj2.getContenanceReservoir(),
						obj2.getContenuReservoir());

				obj2.setContenuReservoir(obj2.getContenanceReservoir());
				obj1.setContenu(obj1.getContenu() - toFill);

				affiche_info_apres_replissage(toFill, obj1.getContenu(), obj2.getContenuReservoir());
			} else {
				toFill = obj1.getContenu();

				affiche_info_avant_remplissage(toFill, obj1.getContenu(), obj2.getContenanceReservoir(),
						obj2.getContenuReservoir());

				obj2.setContenuReservoir(obj2.getContenuReservoir() + toFill);
				obj1.setContenu(0);

				affiche_info_apres_replissage(toFill, obj1.getContenu(), obj2.getContenuReservoir());
			}
		} else {
			System.out.println("No pomp with the same carburant");
		}
	}

	public static void affiche_info_avant_remplissage(int tf, int c1, int c2, int c3) {
		System.out.println("Niveau actuel d'essence dans la pompe: " + c1);
		System.out.println("Capacité du réservoir d'essence dans la voiture: " + c2);
		System.out.println("Niveau d'essence actuel dans la voiture: " + c3);
		System.out.println("Essence à remplir : " + tf);
		System.out.println("<---Remplissage du Réservoir ---->");
	}

	public static void affiche_info_apres_replissage(int tf, int c1, int c2) {
		System.out.println("Niveau d'essence dans la pompe après le remplissage: " + c1);
		System.out.println("Niveau d'essence dans la voiture après le remplissage: " + c2);
	}

}
