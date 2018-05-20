package fr.domaine;

public class Client {

	// DECLARATION DES PROPRIETES
	private int idClient;
	private String nom;
	private String prenom;
	private int age;
	private int idConseiller;

	// GETTERS / SETTERS
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	// CONSTRUCTEURS
	public Client(String nom, String prenom, int age, int idConseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.idConseiller = idConseiller;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom) {
		
	}
     //ToString
	public String toString() {
		return "- Id du Client : " + this.idClient + ", Nom : " + this.nom + ", Prénom : " + this.prenom + ", Age : "
				+ this.age + ", Conseiller : " + this.idConseiller;
	}

}
