package apresmidi1;

import java.util.concurrent.atomic.AtomicInteger;

public class Roles {
	private static final AtomicInteger count = new AtomicInteger();
	private final int id;

	private String nom_du_role;

	public Roles() {
		super();
		this.id = (int) Math.random();
		this.nom_du_role = "nom_not_set";
	}

	public Roles(String nom_du_role) {
		super();
		this.id = count.getAndIncrement();
		this.nom_du_role = nom_du_role;
	}

	public String getNom_du_role() {
		return nom_du_role;
	}

	public void setNom_du_role(String nom_du_role) {
		this.nom_du_role = nom_du_role;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", nom_du_role=" + nom_du_role + "]";
	}
}
