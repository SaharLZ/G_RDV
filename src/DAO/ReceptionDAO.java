package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Reception;

public class ReceptionDAO {
    private Connection connection;

    public ReceptionDAO(Connection connection) {
        this.connection = connection;
    }

    // CREATE
    public void ajouterReception(Reception reception) throws SQLException {
        String sql = "INSERT INTO reception (nom, mail, mdp) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reception.getNom());
            ps.setString(2, reception.getMail());
            ps.setString(3, reception.getMdp());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }

    // READ
    public List<Reception> getToutesLesReceptions() throws SQLException {
        List<Reception> receptions = new ArrayList<Reception>();
        String sql = "SELECT * FROM reception";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Reception r = new Reception(0, sql, sql, sql, sql);
                r.setId(rs.getInt("id"));
                r.setNom(rs.getString("nom"));
                r.setMail(rs.getString("mail"));
                r.setMdp(rs.getString("mdp"));
                receptions.add(r);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
        return receptions;
    }

    // UPDATE
    public void modifierReception(Reception reception) throws SQLException {
        String sql = "UPDATE reception SET nom = ?, mail = ?, mdp = ? WHERE id = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reception.getNom());
            ps.setString(2, reception.getMail());
            ps.setString(3, reception.getMdp());
            ps.setInt(4, reception.getId());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }

    // DELETE
    public void supprimerReception(int id) throws SQLException {
        String sql = "DELETE FROM reception WHERE id = ?";
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
