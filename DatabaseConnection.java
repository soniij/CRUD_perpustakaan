import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Perpustakaan"; // Ganti sesuai database Anda
    private static final String USER = "root"; // Ganti dengan username MySQL Anda
    private static final String PASSWORD = "ahmadsonitoro2005"; // Ganti dengan password MySQL Anda

    // Fungsi untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
