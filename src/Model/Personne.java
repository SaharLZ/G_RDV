package Model;

public class Personne {
	private int Id;
	private String Nom;
	private String Prenom;
	private String Mail;
	private String Mdp;
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
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	
	public Personne(int id, String nom, String prenom, String mail, String mdp) {
		Id = id;
		Nom = nom;
		Prenom = prenom;
		Mail = mail;
		Mdp = mdp;
	}
	public Personne() {
		
	}
	
	
	
}
