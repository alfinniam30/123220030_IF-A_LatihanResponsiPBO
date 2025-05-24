package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/latihanresponsi"; // GANTI di sini
    private static final String DB_USER = "root";  // sesuaikan user MySQL-mu
    private static final String DB_PASS = "";      // sesuaikan password MySQL-mu

    public static Connection connectDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Koneksi Berhasil ke MySQL");
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return conn;
    }
}
