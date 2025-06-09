package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Ordonnance;
import Model.Patient;
import Model.RDV;

public class RDVDAO {
    private Connection connection;

    public RDVDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void ajouterRDV(RDV rdv) throws SQLException {
        String sql = "INSERT INTO RDV(Date, Heure, Etat, Note, Patient, Ord) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, rdv.getDate());
            ps.setString(2, rdv.getHeure());
            ps.setString(3, rdv.getEtat());
            ps.setString(4, rdv.getNote());
            ps.setInt(5, rdv.getPatient().getId());
            ps.setInt(6, rdv.getOrd().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // READ
    public List<RDV> getTousLesRDV() throws SQLException {
        List<RDV> liste = new ArrayList<RDV>();
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM RDV";
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                RDV r = new RDV();
                r.setId(rs.getInt("Id"));
                r.setDate(rs.getString("Date"));
                r.setHeure(rs.getString("Heure"));
                r.setEtat(rs.getString("Etat"));
                r.setNote(rs.getString("Note"));

                Patient patient = new Patient();
                patient.setId(rs.getInt("Patient")); 
                r.setPatient(patient);

                Ordonnance ordonnance = new Ordonnance();
                ordonnance.setId(rs.getInt("Ord")); 
                r.setOrd(ordonnance);

                liste.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return liste;
    }

    // UPDATE
    public void modifierRDV(RDV rdv) throws SQLException {
        String sql = "UPDATE RDV SET Date = ?, Heure = ?, Etat = ?, Note = ?, Patient = ?, Ord = ? WHERE Id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, rdv.getDate());
            ps.setString(2, rdv.getHeure());
            ps.setString(3, rdv.getEtat());
            ps.setString(4, rdv.getNote());
            ps.setInt(5, rdv.getPatient().getId());
            ps.setInt(6, rdv.getOrd().getId());
            ps.setInt(7, rdv.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // DELETE
    public void supprimerRDV(int id) throws SQLException {
        String sql = "DELETE FROM RDV WHERE Id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    
    }
}
