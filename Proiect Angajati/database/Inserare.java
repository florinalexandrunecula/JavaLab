package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserare {

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

    public void insertCompanyName(String nume){
        String sql = "INSERT INTO CompanyNames(nume) VALUES(?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertCTO(String nume, String prenume, int vechime, int anAngajare, String post){
        String sql = "INSERT INTO CTOs(nume, prenume, vechime, anAngajare, post) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setInt(3, vechime);
            pstmt.setInt(4, anAngajare);
            pstmt.setString(5, post);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertProjectManager(String nume, String prenume, int vechime, int anAngajare, String post, String proiect){
        String sql = "INSERT INTO ProjectManagers(nume, prenume, vechime, anAngajare, post, proiect) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setInt(3, vechime);
            pstmt.setInt(4, anAngajare);
            pstmt.setString(5, post);
            pstmt.setString(6, proiect);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertSoftDev(String nume, String prenume, int vechime, int anAngajare, String post, int munceste) {
        String sql = "INSERT INTO SoftDevs(nume, prenume, vechime, anAngajare, post, munceste) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setInt(3, vechime);
            pstmt.setInt(4, anAngajare);
            pstmt.setString(5, post);
            pstmt.setInt(6, munceste);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
