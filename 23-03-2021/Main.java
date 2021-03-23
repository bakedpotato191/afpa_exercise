package das;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Metier> m = new ArrayList<Metier>();
		ArrayList<Personne> p = new ArrayList<Personne>();

		m.add(new Metier("Menuisier"));
		m.add(new Metier("Plombier"));

		p.add(new Personne("John", "Doe", m.get(0)));
		p.add(new Personne("Juan", "Doe1", m.get(1)));
		p.add(new Personne("Jane", "Doe2", m.get(0)));

		for (Personne i : p) {
			System.out.println(i);
		}
	}

}
