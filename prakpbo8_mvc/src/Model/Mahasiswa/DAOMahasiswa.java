package Model.Mahasiswa;

import Model.Connector;
import java.sql.*;
import java.util.*;

public class DAOMahasiswa implements InterfaceDAOMahasiswa {
    Connection conn = Connector.connectDB();

    @Override
    public void insert(Mahasiswa m) {
        try {
            String query = "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, m.getNama());
            stmt.setString(2, m.getNim());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert Error: " + e.getMessage());
        }
    }

    @Override
    public void update(Mahasiswa m) {
        try {
            String query = "UPDATE mahasiswa SET nama=?, nim=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, m.getNama());
            stmt.setString(2, m.getNim());
            stmt.setInt(3, m.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update Error: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM mahasiswa WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete Error: " + e.getMessage());
        }
    }

    @Override
    public List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM mahasiswa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa(rs.getInt("id"), rs.getString("nama"), rs.getString("nim"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println("GetAll Error: " + e.getMessage());
        }
        return list;
    }
}
