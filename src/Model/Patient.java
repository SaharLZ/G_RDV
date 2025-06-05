package Model;

public class Patient {
	private int Id;
	private String Nom;
	private String Prenom;
	private String Date;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public Patient(int id, String nom, String prenom, String date) {
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Date = date;
	}	
	public Patient() {
	    // Constructeur vide 
	}
	
}
