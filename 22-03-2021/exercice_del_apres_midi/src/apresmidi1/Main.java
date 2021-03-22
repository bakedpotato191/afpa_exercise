package apresmidi1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		ArrayList<Roles> role = new ArrayList<Roles>();

		role.add(new Roles("Chef de projet"));
		role.add(new Roles("Manager"));
		role.add(new Roles("Développeur"));

		users.add(new Utilisateur("nomTest1", "prenomTest1", "test1@gmail.com", "0687568954", role.get(1)));
		users.add(new Utilisateur("nomTest2", "prenomTest2", "test2@gmail.com", "0686198955", role.get(1)));
		users.add(new Utilisateur("nomTest3", "prenomTest3", "test3@gmail.com", "0717768954", role.get(2)));

		for (Utilisateur i : users) {
			System.out.println(i);
		}
	}

}
