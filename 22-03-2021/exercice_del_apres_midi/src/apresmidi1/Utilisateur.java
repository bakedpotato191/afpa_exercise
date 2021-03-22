package apresmidi1;

import java.util.concurrent.atomic.AtomicInteger;

public class Utilisateur {
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int id;
	private String nom;
	private String prenom;
	private String email;
	private String phoneNumber;
	private Roles role;

	public Utilisateur() {
		super();
		this.id = count.incrementAndGet();
		this.nom = "nom_not_set";
		this.prenom = "prenom_not_set";
		this.email = "email_not_set";
		this.phoneNumber = "phoneNumber_not_set";
	}

	public Utilisateur(String nom, String prenom, String email, String phoneNumber, Roles role) {
		super();
		this.id = count.incrementAndGet();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Roles getRole() {
		return role;
	}

	public static AtomicInteger getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", role=" + role + "]";
	}

}
