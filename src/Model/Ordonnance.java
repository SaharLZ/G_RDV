package Model;

public class Ordonnance {
	private int Id;
	private String Date;
	private String Contenu;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
	public Ordonnance(int id, String date, String contenu) {
		Id = id;
		Date = date;
		Contenu = contenu;
	}
	public Ordonnance() {
		// TODO Auto-generated constructor stub
	}
	
}

