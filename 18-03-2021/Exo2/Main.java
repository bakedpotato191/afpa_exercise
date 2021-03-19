package exo2;

public class Main {

	public static void main(String[] args) {
		
		new Specialite("JAVA/JEE");
		new Specialite("HTML/CSS");
		new Specialite("Gestion de projet");
		new Specialite("JS");
		new Specialite("PHP");
		
		Enseignant e1 = new Enseignant("Toutain", "Damien", "JAVA/JEE");
		Enseignant e2 = new Enseignant("Micheaux", "Francis", "JAVA/JEE");
		Enseignant e3 = new Enseignant("Souchon", "Bernard", "PHP");
		Enseignant e4 = new Enseignant("Astier", "Carla", "JS");
		
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e1);

	}

}
