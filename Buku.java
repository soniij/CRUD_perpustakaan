import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Buku {
    private int id; // ID buku
    private String judul; // Judul buku
    private String penulis; // Penulis buku

    // Constructor kosong
    public Buku() {
    }

    // Constructor dengan parameter
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // Menambahkan buku ke database
    public void simpan() throws SQLException {
        String sql = "INSERT INTO buku (judul, penulis) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.judul);
            stmt.setString(2, this.penulis);
            stmt.executeUpdate();
            System.out.println("Buku berhasil disimpan ke database!");
        }
    }

    // Menampilkan semua buku
    public static List<Buku> ambilSemuaBuku() throws SQLException {
        List<Buku> daftarBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Buku buku = new Buku();
                buku.setId(rs.getInt("id"));
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                daftarBuku.add(buku);
            }
        }
        return daftarBuku;
    }

    // Memperbarui data buku
    public void perbarui() throws SQLException {
        String sql = "UPDATE buku SET judul = ?, penulis = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, this.judul);
            stmt.setString(2, this.penulis);
            stmt.setInt(3, this.id);
            stmt.executeUpdate();
            System.out.println("Buku berhasil diperbarui!");
        }
    }

    // Menghapus buku berdasarkan ID
    public static void hapusBerdasarkanId(int id) throws SQLException {
        String sql = "DELETE FROM buku WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Buku berhasil dihapus!");
        }
    }
}
