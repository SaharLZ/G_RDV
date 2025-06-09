package Model;

import Model.Ordonnance;
import Model.Patient;

public class RDV {
	private int Id;
	private String Date;
	private String Heure;
	private String Etat;
	private String Note;
	private Patient Patient;
	private Ordonnance Ord;
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
	public String getHeure() {
		return Heure;
	}
	public void setHeure(String heure) {
		Heure = heure;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public Patient getPatient() {
		return Patient;
	}
	public void setPatient(Patient patient) {
		Patient = patient;
	}
	public Ordonnance getOrd() {
		return Ord;
	}
	public void setOrd(Ordonnance ord) {
		Ord = ord;
	}
	public void setNote(String note) {
		Note = note;
	}
	public String getNote() {
		return Note;
	}
	public RDV(int id, String date, String heure, String etat, Patient patient,
			Ordonnance ord) {
		Id = id;
		Date = date;
		Heure = heure;
		Etat = etat;
		Patient = patient;
		Ord = ord;
	}
	public RDV() {
		// TODO Auto-generated constructor stub
	}
	
}
