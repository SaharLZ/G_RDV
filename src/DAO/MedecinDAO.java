package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Medecin;

public class MedecinDAO {
    private Connection connection;

    public MedecinDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterMedecin(Medecin medecin) throws SQLException {
        String sql = "INSERT INTO medecin (nom, specialite) VALUES (?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, medecin.getNom()); // hérité de Personne
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Medecin> getTousLesMedecins() throws SQLException {
        List<Medecin> medecins = new ArrayList<Medecin>();
        String sql = "SELECT * FROM medecin";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medecin m = new Medecin(0, sql, sql, sql, sql); 
                m.setId(rs.getInt("id"));           
                m.setNom(rs.getString("nom"));      
                medecins.add(m);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
        return medecins;
    }

    public void supprimerMedecin(int id) throws SQLException {
        String sql = "DELETE FROM medecin WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }
}
