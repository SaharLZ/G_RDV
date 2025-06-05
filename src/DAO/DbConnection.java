package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/nom_de_ta_base"; // remplace avec le nom de ta base
    private static final String USER = "root"; // ou ton utilisateur
    private static final String PASSWORD = ""; // ou ton mot de passe

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // charge le driver MySQL
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver MySQL introuvable");
        }
    }
}
