package exo;

public class Vehicule {
	private static int toFill;

	public static void fairePlein(Pompe obj1, Voiture obj2) {
		if (obj1.getTypeCarburant1().equals(obj2.getTypeCarburant())) {
			if (obj1.getContenu() > (obj2.getContenanceReservoir() - obj2.getContenuReservoir())) {
				toFill = obj2.getContenanceReservoir() - obj2.getContenuReservoir();

				System.out.println("Total gas in pump: " + obj1.getContenu());
				System.out.println("Tank capacity: " + obj2.getContenanceReservoir());
				System.out.println("Current gas level " + obj2.getContenuReservoir());
				System.out.println("Gas to be filled: " + toFill);
				System.out.println("<---Filling the tank---->");

				obj2.setContenuReservoir(obj2.getContenanceReservoir());
				obj1.setContenu(obj1.getContenu() - toFill);

				System.out.println("Remaining in pump: " + obj1.getContenu());
				System.out.println("Currect gas level: " + obj2.getContenuReservoir());

			} else {
				toFill = obj1.getContenu();
				System.out.println("Total gas in pump: " + obj1.getContenu());
				System.out.println("Tank capacity: " + obj2.getContenanceReservoir());
				System.out.println("Current gas level " + obj2.getContenuReservoir());
				System.out.println("Gas to fill: " + obj1.getContenu());

				obj2.setContenuReservoir(obj2.getContenuReservoir() + toFill);
				obj1.setContenu(0);

				System.out.println("Remaining in pump: " + obj1.getContenu());
				System.out.println("Gas in tank after the fill: " + obj2.getContenuReservoir());
			}
		} else {
			System.out.println("No pomp with the same carburant");
		}
	}
}
