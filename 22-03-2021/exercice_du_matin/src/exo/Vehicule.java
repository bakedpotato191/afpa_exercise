package exo;

public class Vehicule {
	private static int toFill;
	private static int pContenu;
	private static int vContenance;
	private static int vContenu;
	private static String pCarburant;
	private static String vCarburant;

	public static void fairePlein(Pompe p1, Voiture v1) {
		pCarburant = p1.getTypeCarburant1();
		vCarburant = v1.getTypeCarburant();

		if (pCarburant.equals(vCarburant)) {

			pContenu = p1.getContenu();
			vContenance = v1.getContenanceReservoir();
			vContenu = v1.getContenuReservoir();

			if (p1.getContenu() > (v1.getContenanceReservoir() - v1.getContenuReservoir())) {
				toFill = vContenance - vContenu;
				affiche_info_avant_remplissage(toFill, pContenu, vContenance, vContenu);

				v1.setContenuReservoir(vContenance);
				p1.setContenu((byte) (pContenu - toFill));
				pContenu = p1.getContenu();

				affiche_info_apres_replissage(pContenu, vContenance);
			} else {
				toFill = pContenu;

				affiche_info_avant_remplissage(toFill, pContenu, vContenance, vContenu);

				v1.setContenuReservoir(vContenu + toFill);
				p1.setContenu((byte) 0);
				pContenu = p1.getContenu();
				vContenu = v1.getContenuReservoir();

				affiche_info_apres_replissage(pContenu, vContenu);
			}
		} else {
			System.out.println("Utiliser une autre pompe");
		}
	}

	private static void affiche_info_avant_remplissage(int tf, int c1, int c2, int c3) {
		System.out.println("Niveau actuel d'essence dans la pompe: " + c1);
		System.out.println("Capacité du réservoir d'essence dans la voiture: " + c2);
		System.out.println("Niveau d'essence actuel dans la voiture: " + c3);
		System.out.println("Essence à remplir : " + tf);
		System.out.println("<---Remplissage du Réservoir ---->");
	}

	private static void affiche_info_apres_replissage(int c1, int c2) {
		System.out.println("Niveau d'essence dans la pompe après le remplissage: " + c1);
		System.out.println("Niveau d'essence dans la voiture après le remplissage: " + c2);
	}

}
