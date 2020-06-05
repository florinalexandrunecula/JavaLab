package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stergere {

    private Connection connect(String fileName) {
        String url = "jdbc:sqlite:src/DataBases/" + fileName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void deleteCompanyName(String nume) {
        String sql = "DELETE FROM CompanyNames WHERE nume = ?";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCTO(String nume, String prenume) {
        String sql = "DELETE FROM CTOs WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProjectManager(String nume, String prenume) {
        String sql = "DELETE FROM ProjectManagers WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSoftDev(String nume, String prenume) {
        String sql = "DELETE FROM SoftDevs WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
