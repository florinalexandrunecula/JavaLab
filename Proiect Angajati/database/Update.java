package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

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

    public void updateCompanyName(String numeVechi, String numeNou) {
        String sql = "UPDATE CompanyNames SET nume = ? WHERE nume = ?";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, numeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCTO(String numeVechi, String prenumeVechi, String numeNou, String prenumeNou, int vechimeNou, int anAngajareNou) {
        String sql = "UPDATE CTOs SET nume = ?, prenume = ?, vechime = ?, anAngajare = ? WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, prenumeNou);
            pstmt.setInt(3, vechimeNou);
            pstmt.setInt(4, anAngajareNou);
            pstmt.setString(5, numeVechi);
            pstmt.setString(6, prenumeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProjectManager(String numeVechi, String prenumeVechi, String numeNou, String prenumeNou, int vechimeNou, int anAngajareNou, String proiectNou) {
        String sql = "UPDATE ProjectManagers SET nume = ?, prenume = ?, vechime = ?, anAngajare = ?, proiect = ? WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, prenumeNou);
            pstmt.setInt(3, vechimeNou);
            pstmt.setInt(4, anAngajareNou);
            pstmt.setString(5, proiectNou);
            pstmt.setString(6, numeVechi);
            pstmt.setString(7, prenumeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSoftDev(String numeVechi, String prenumeVechi, String numeNou, String prenumeNou, int vechimeNou, int anAngajareNou, int muncesteNou) {
        String sql = "UPDATE SoftDevs SET nume = ?, prenume = ?, vechime = ?, anAngajare = ?, munceste = ? WHERE (nume = ? AND prenume = ?)";
        try (Connection conn = this.connect("gestiune.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeNou);
            pstmt.setString(2, prenumeNou);
            pstmt.setInt(3, vechimeNou);
            pstmt.setInt(4, anAngajareNou);
            pstmt.setInt(5, muncesteNou);
            pstmt.setString(6, numeVechi);
            pstmt.setString(7, prenumeVechi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
