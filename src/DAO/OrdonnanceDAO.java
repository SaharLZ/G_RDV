package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.Ordonnance;

public class OrdonnanceDAO {
    private Connection connection;

    public OrdonnanceDAO(Connection connection) {
        this.connection = connection;
    }

    public void ajouterOrdonnance(Ordonnance ordonnance) throws SQLException {
        String sql = "INSERT INTO ordonnance (Contenu, date, id) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, ordonnance.getContenu());
            ps.setString(2, ordonnance.getDate());
            ps.setInt(3, ordonnance.getId());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Ordonnance> getToutesOrdonnances() throws SQLException {
        List<Ordonnance> ordonnances = new ArrayList<Ordonnance>();
        String sql = "SELECT * FROM ordonnance";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Ordonnance o = new Ordonnance();
                o.setId(rs.getInt("id"));
                o.setContenu(rs.getString("contenu"));
                o.setDate(rs.getString("date"));
                o.setId(rs.getInt("id"));
                ordonnances.add(o);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
        return ordonnances;
    }

    public void supprimerOrdonnance(int id) throws SQLException {
        String sql = "DELETE FROM ordonnance WHERE id = ?";
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
