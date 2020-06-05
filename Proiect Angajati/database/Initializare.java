package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Initializare {

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

    public static void createDatabase(String fileName) {
        String url = "jdbc:sqlite:src/DataBases/";
        try (Connection conn = DriverManager.getConnection(url + fileName)) {
            if (conn != null) {
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void createTables() {
        String sql = "CREATE TABLE IF NOT EXISTS CompanyNames (\n"
                + "nume text PRIMARY KEY\n"
                + ");";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS CTOs (\n"
                + "nume text PRIMARY KEY,\n"
                + "prenume text,\n"
                + "vechime integer,\n"
                + "anAngajare integer,\n"
                + "post text\n"
                + ");";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS ProjectManagers (\n"
                + "nume text PRIMARY KEY,\n"
                + "prenume text,\n"
                + "vechime integer,\n"
                + "anAngajare integer,\n"
                + "post text,\n"
                + "proiect text\n"
                + ");";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        sql = "CREATE TABLE IF NOT EXISTS SoftDevs (\n"
                + "nume text PRIMARY KEY,\n"
                + "prenume text,\n"
                + "vechime integer,\n"
                + "anAngajare integer,\n"
                + "post text,\n"
                + "munceste integer\n"
                + ");";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
