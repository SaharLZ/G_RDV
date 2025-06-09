package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Patient;

public class PatientDAO {
    private Connection connection;

    public PatientDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void ajouterPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patient(Nom, Prenom, Date, Blood, Adress, Medical_note) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getDate());
            ps.setString(4, patient.getBlood());
            ps.setString(5, patient.getAdress());
            ps.setString(6, patient.getMedical_note());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // READ
    public List<Patient> getTousLesPatients() throws SQLException {
        List<Patient> patients = new ArrayList<Patient>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Patient";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Patient p = new Patient();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nom"));
                p.setPrenom(rs.getString("Prenom"));
                p.setDate(rs.getString("Date"));
                p.setAdress(rs.getString("Adress"));
                p.setBlood(rs.getString("Blood"));
                p.setMedical_note(rs.getString("Medical_note"));
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return patients;
    }

    // UPDATE
    public void modifierPatient(Patient patient) throws SQLException {
        String sql = "UPDATE Patient SET Nom = ?, Prenom = ?, Date = ? , Blood = ? , Medical_note = ? WHERE Id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, patient.getNom());
            ps.setString(2, patient.getPrenom());
            ps.setString(3, patient.getDate());
            ps.setString(4, patient.getBlood());
            ps.setString(5, patient.getAdress());
            ps.setString(6, patient.getMedical_note());
            ps.setInt(7, patient.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // DELETE
    public void supprimerPatient(int id) throws SQLException {
        String sql = "DELETE FROM Patient WHERE Id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
