package database;

import model.Angajat;

import java.sql.*;
import java.util.ArrayList;

public class Citire {

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

    public String[] readCTOs() {
        String sql = "SELECT COUNT(*) AS total FROM CTOs";
        int size = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post FROM CTOs";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                String rezultat = nume + ", " + prenume + ", " + Integer.toString(vechime) + ", " + Integer.toString(anAngajare) + ", " + post;
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public String[] readCompanyNames() {
        String sql = "SELECT COUNT(*) AS total FROM CompanyNames";
        int size = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume FROM CompanyNames";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String rezultat = nume;
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public String[] readProjectManagers() {
        String sql = "SELECT COUNT(*) AS total FROM ProjectManagers";
        int size = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, proiect FROM ProjectManagers";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                String proiect = rs.getString("proiect");
                String rezultat = nume + ", " + prenume + ", " + Integer.toString(vechime) + ", " + Integer.toString(anAngajare) + ", " + post + ", " + proiect;
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public String[] readSoftDevs() {
        String sql = "SELECT COUNT(*) AS total FROM SoftDevs";
        int size = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, munceste FROM SoftDevs";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect("gestiune.db");
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                int munceste = rs.getInt("munceste");
                String rezultat = nume + ", " + prenume + ", " + Integer.toString(vechime) + ", " + Integer.toString(anAngajare) + ", " + post + ", " + munceste;
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }
}
