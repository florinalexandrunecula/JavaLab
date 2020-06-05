package database;

import model.Angajat;
import model.CTO;
import model.ProjMan;
import model.SoftDev;
import util.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Database {

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

    public void createTables(String fileName) {
        String sql = "CREATE TABLE IF NOT EXISTS CompanyNames (\n"
                + "nume text PRIMARY KEY\n"
                + ");";
        try (Connection conn = this.connect(fileName);
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
                + "post text,\n"
                + "salariu integer\n "
                + ");";
        try (Connection conn = this.connect(fileName);
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
                + "proiect text,\n"
                + "salariu integer\n"
                + ");";
        try (Connection conn = this.connect(fileName);
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
                + "munceste integer,\n"
                + "salariu integer\n"
                + ");";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertCompanyName(String nume, String fileName){
        String sql = "INSERT INTO CompanyNames(nume) VALUES(?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertCTO(String nume, String prenume, int vechime, int anAngajare, String post, int salariu, String fileName){
        String sql = "INSERT INTO CTOs(nume, prenume, vechime, anAngajare, post, salariu) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setInt(3, vechime);
            pstmt.setInt(4, anAngajare);
            pstmt.setString(5, post);
            pstmt.setInt(6, salariu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertProjectManager(String nume, String prenume, int vechime, int anAngajare, String post, String proiect, int salariu, String fileName){
        String sql = "INSERT INTO ProjectManagers(nume, prenume, vechime, anAngajare, post, proiect, salariu) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setInt(3, vechime);
            pstmt.setInt(4, anAngajare);
            pstmt.setString(5, post);
            pstmt.setString(6, proiect);
            pstmt.setInt(7, salariu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertSoftDev(String nume, String prenume, int vechime, int anAngajare, String post, int munceste, int salariu, String fileName) {
        String sql = "INSERT INTO SoftDevs(nume, prenume, vechime, anAngajare, post, munceste, salariu) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.setInt(3, vechime);
            pstmt.setInt(4, anAngajare);
            pstmt.setString(5, post);
            pstmt.setInt(6, munceste);
            pstmt.setInt(7, salariu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public String[] readCTOs(String fileName) {
        String sql = "SELECT COUNT(*) AS total FROM CTOs";
        int size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, salariu FROM CTOs";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                int salariu = rs.getInt("salariu");
                String rezultat = nume + ", " + prenume + ", " + Integer.toString(vechime) + ", " + Integer.toString(anAngajare) + ", " + post + ", " + Integer.toString(salariu);
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public String[] readCompanyNames(String fileName) {
        String sql = "SELECT COUNT(*) AS total FROM CompanyNames";
        int size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume FROM CompanyNames";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect(fileName);
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

    public String[] readProjectManagers(String fileName) {
        String sql = "SELECT COUNT(*) AS total FROM ProjectManagers";
        int size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, proiect, salariu FROM ProjectManagers";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                String proiect = rs.getString("proiect");
                int salariu = rs.getInt("salariu");
                String rezultat = nume + ", " + prenume + ", " + Integer.toString(vechime) + ", " + Integer.toString(anAngajare) + ", " + post + ", " + proiect + ", " + Integer.toString(salariu);
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public String[] readSoftDevs(String fileName) {
        String sql = "SELECT COUNT(*) AS total FROM SoftDevs";
        int size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, munceste, salariu FROM SoftDevs";
        String[] results = new String[size];
        int count = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                int munceste = rs.getInt("munceste");
                int salariu = rs.getInt("salariu");
                String rezultat = nume + ", " + prenume + ", " + Integer.toString(vechime) + ", " + Integer.toString(anAngajare) + ", " + post + ", " + munceste + ", " + Integer.toString(salariu);
                results[count] = "'" + rezultat + "'";
                count++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public void updateCompanyName(String numeVechi, String numeNou, String fileName) {
        String sql = "UPDATE CompanyNames SET nume = ? WHERE nume = ?";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, numeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCTO(String numeVechi, String prenumeVechi, String numeNou, String prenumeNou, int vechimeNou, int anAngajareNou, int salariuNou, String fileName) {
        String sql = "UPDATE CTOs SET nume = ?, prenume = ?, vechime = ?, anAngajare = ?, salariu = ? WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, prenumeNou);
            pstmt.setInt(3, vechimeNou);
            pstmt.setInt(4, anAngajareNou);
            pstmt.setInt(5, salariuNou);
            pstmt.setString(6, numeVechi);
            pstmt.setString(7, prenumeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProjectManager(String numeVechi, String prenumeVechi, String numeNou, String prenumeNou, int vechimeNou, int anAngajareNou, String proiectNou, int salariuNou, String fileName) {
        String sql = "UPDATE ProjectManagers SET nume = ?, prenume = ?, vechime = ?, anAngajare = ?, proiect = ?, salariu = ? WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, prenumeNou);
            pstmt.setInt(3, vechimeNou);
            pstmt.setInt(4, anAngajareNou);
            pstmt.setString(5, proiectNou);
            pstmt.setInt(6, salariuNou);
            pstmt.setString(7, numeVechi);
            pstmt.setString(8, prenumeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSoftDev(String numeVechi, String prenumeVechi, String numeNou, String prenumeNou, int vechimeNou, int anAngajareNou, int muncesteNou, int salariuNou, String fileName) {
        String sql = "UPDATE SoftDevs SET nume = ?, prenume = ?, vechime = ?, anAngajare = ?, munceste = ?, salariu = ? WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, prenumeNou);
            pstmt.setInt(3, vechimeNou);
            pstmt.setInt(4, anAngajareNou);
            pstmt.setInt(5, muncesteNou);
            pstmt.setInt(6, salariuNou);
            pstmt.setString(7, numeVechi);
            pstmt.setString(8, prenumeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCompanyName(String nume, String fileName) {
        String sql = "DELETE FROM CompanyNames WHERE nume = ?";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCTO(String nume, String prenume, String fileName) {
        String sql = "DELETE FROM CTOs WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteProjectManager(String nume, String prenume, String fileName) {
        String sql = "DELETE FROM ProjectManagers WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSoftDev(String nume, String prenume, String fileName) {
        String sql = "DELETE FROM SoftDevs WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect(fileName);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Angajat[] readAllEmployees(String fileName){
        ArrayList<Angajat> aux = new ArrayList<>();
        String sql = "SELECT COUNT(*) AS total FROM SoftDevs";
        int size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, munceste FROM SoftDevs";
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                int munceste = rs.getInt("munceste");
                boolean working;
                working = munceste != 0;
                SoftDev softDev = new SoftDev(nume, prenume, vechime, anAngajare, post, working);
                aux.add(softDev);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT COUNT(*) AS total FROM ProjectManagers";
        size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post, proiect FROM ProjectManagers";
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                String proiect = rs.getString("proiect");
                ProjMan projMan = new ProjMan(nume, prenume, vechime, anAngajare, post, proiect);
                aux.add(projMan);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT COUNT(*) AS total FROM CTOs";
        size = 0;
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            size = rs.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "SELECT nume, prenume, vechime, anAngajare, post FROM CTOs";
        try (Connection conn = this.connect(fileName);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                String nume = rs.getString("nume");
                String prenume = rs.getString("prenume");
                int vechime = rs.getInt("vechime");
                int anAngajare = rs.getInt("anAngajare");
                String post = rs.getString("post");
                CTO cto = CTO.createCTO(nume, prenume, vechime, anAngajare, post);
                aux.add(cto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Angajat[] angajati = new Angajat[aux.size()];
        angajati = aux.toArray(angajati);
        return angajati;
    }

//    public static void main(String[] args) {
//
//        // Creez bazele de date cu valorile initiale luate din CSV
//
//        Database MyDB = new Database();
//        MyDB.createDatabase("Gestiune.db");
//        MyDB.createTables();
//        Reader Cititorul = Reader.getInstance();
//        String[][] CompanyNames = Cititorul.readContent("CompanyNames.csv");
//        String[][] CTOs = Cititorul.readContent("CTOs.csv");
//        String[][] ProjectManagers = Cititorul.readContent("ProjectManagers.csv");
//        String[][] SoftDevs = Cititorul.readContent("SoftDevs.csv");
//        MyDB.insertSoftDev(SoftDevs[0][0], SoftDevs[0][1], Integer.parseInt(SoftDevs[0][2]), Integer.parseInt(SoftDevs[0][3]), SoftDevs[0][4], Integer.parseInt(SoftDevs[0][5]));
//        MyDB.insertSoftDev(SoftDevs[1][0], SoftDevs[1][1], Integer.parseInt(SoftDevs[1][2]), Integer.parseInt(SoftDevs[1][3]), SoftDevs[1][4], Integer.parseInt(SoftDevs[1][5]));
//        MyDB.insertProjectManager(ProjectManagers[0][0], ProjectManagers[0][1], Integer.parseInt(ProjectManagers[0][2]), Integer.parseInt(ProjectManagers[0][3]), ProjectManagers[0][4], ProjectManagers[0][5]);
//        MyDB.insertCTO(CTOs[0][0], CTOs[0][1], Integer.parseInt(CTOs[0][2]), Integer.parseInt(CTOs[0][3]), CTOs[0][4]);
//        MyDB.insertCompanyName(CompanyNames[0][0]);
//        MyDB.insertSoftDev(SoftDevs[2][0], SoftDevs[2][1], Integer.parseInt(SoftDevs[2][2]), Integer.parseInt(SoftDevs[2][3]), SoftDevs[2][4], Integer.parseInt(SoftDevs[2][5]));
//        MyDB.insertSoftDev(SoftDevs[3][0], SoftDevs[3][1], Integer.parseInt(SoftDevs[3][2]), Integer.parseInt(SoftDevs[3][3]), SoftDevs[3][4], Integer.parseInt(SoftDevs[3][5]));
//        MyDB.insertSoftDev(SoftDevs[4][0], SoftDevs[4][1], Integer.parseInt(SoftDevs[4][2]), Integer.parseInt(SoftDevs[4][3]), SoftDevs[4][4], Integer.parseInt(SoftDevs[4][5]));
//        MyDB.insertProjectManager(ProjectManagers[1][0], ProjectManagers[1][1], Integer.parseInt(ProjectManagers[1][2]), Integer.parseInt(ProjectManagers[1][3]), ProjectManagers[1][4], ProjectManagers[1][5]);
//        System.out.println(Arrays.toString(MyDB.readCompanyNames()));
//        System.out.println(Arrays.toString(MyDB.readProjectManagers()));
//        System.out.println(Arrays.toString(MyDB.readCTOs()));
//        System.out.println(Arrays.toString(MyDB.readSoftDevs()));
////        MyDB.updateCTO("Cook", "Tim", "Jobs", "Steve", 30, 1975);
////        System.out.println(Arrays.toString(MyDB.readCTOs()));
////        MyDB.deleteSoftDev("Necula", "Alexandru");
////        System.out.println(Arrays.toString(MyDB.readSoftDevs()));
//    }
}
