package Model;

public class Patient {
	private int Id;
	private String Nom;
	private String Prenom;
	private String Date;
	private String Blood;
	private String Adress;
	private String Medical_note;
	
	
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
	public void setBlood(String blood) {
		Blood = blood;
	}
	public String getBlood() {
		return Blood;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getAdress() {
		return Adress;
	}
	public void setMedical_note(String medical_note) {
		Medical_note = medical_note;
	}
	public String getMedical_note() {
		return Medical_note;
	}
	
}
