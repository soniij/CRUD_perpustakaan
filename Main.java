import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Perbarui Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            try {
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Masukkan judul buku: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan penulis buku: ");
                        String penulis = scanner.nextLine();
                        Buku buku = new Buku(judul, penulis);
                        buku.simpan();
                    }
                    case 2 -> {
                        List<Buku> daftarBuku = Buku.ambilSemuaBuku();
                        System.out.println("\n=== Daftar Buku ===");
                        for (Buku buku : daftarBuku) {
                            System.out.printf("ID: %d | Judul: %s | Penulis: %s%n",
                                    buku.getId(), buku.getJudul(), buku.getPenulis());
                        }
                    }
                    case 3 -> {
                        System.out.print("Masukkan ID buku yang ingin diperbarui: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Konsumsi newline
                        System.out.print("Masukkan judul baru: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan penulis baru: ");
                        String penulis = scanner.nextLine();
                        Buku buku = new Buku(judul, penulis);
                        buku.setId(id);
                        buku.perbarui();
                    }
                    case 4 -> {
                        System.out.print("Masukkan ID buku yang ingin dihapus: ");
                        int id = scanner.nextInt();
                        Buku.hapusBerdasarkanId(id);
                    }
                    case 5 -> {
                        System.out.println("Keluar dari program. Sampai jumpa!");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (SQLException e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}
