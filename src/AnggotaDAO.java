import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnggotaDAO {
    private Connection koneksi;

    public AnggotaDAO() {
        this.koneksi = Koneksi.getKoneksi();
    }

    // Create
    public boolean tambahAnggota(Anggota anggota) {
        String sql = "INSERT INTO anggota (nama, alamat, no_telp, email, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, anggota.getNama());
            ps.setString(2, anggota.getAlamat());
            ps.setString(3, anggota.getNoTelp());
            ps.setString(4, anggota.getEmail());
            ps.setString(5, anggota.getStatus());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error menambah anggota: " + e.getMessage());
            return false;
        }
    }

    // Read
    public List<Anggota> getAllAnggota() {
        List<Anggota> daftarAnggota = new ArrayList<>();
        String sql = "SELECT * FROM anggota";
        try (Statement stmt = koneksi.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdAnggota(rs.getInt("id_anggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setNoTelp(rs.getString("no_telp"));
                anggota.setEmail(rs.getString("email"));
                anggota.setStatus(rs.getString("status"));
                daftarAnggota.add(anggota);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data anggota: " + e.getMessage());
        }
        return daftarAnggota;
    }

    // Update
    public boolean updateAnggota(Anggota anggota) {
        String sql = "UPDATE anggota SET nama=?, alamat=?, no_telp=?, email=?, status=? WHERE id_anggota=?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, anggota.getNama());
            ps.setString(2, anggota.getAlamat());
            ps.setString(3, anggota.getNoTelp());
            ps.setString(4, anggota.getEmail());
            ps.setString(5, anggota.getStatus());
            ps.setInt(6, anggota.getIdAnggota());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error update anggota: " + e.getMessage());
            return false;
        }
    }

    // Delete
    public boolean hapusAnggota(int idAnggota) {
        String sql = "DELETE FROM anggota WHERE id_anggota=?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setInt(1, idAnggota);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error hapus anggota: " + e.getMessage());
            return false;
        }
    }

    // Search
    public List<Anggota> cariAnggota(String keyword) {
        List<Anggota> hasil = new ArrayList<>();
        String sql = "SELECT * FROM anggota WHERE nama LIKE ? OR email LIKE ? OR no_telp LIKE ?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Anggota anggota = new Anggota();
                anggota.setIdAnggota(rs.getInt("id_anggota"));
                anggota.setNama(rs.getString("nama"));
                anggota.setAlamat(rs.getString("alamat"));
                anggota.setNoTelp(rs.getString("no_telp"));
                anggota.setEmail(rs.getString("email"));
                anggota.setStatus(rs.getString("status"));
                hasil.add(anggota);
            }
        } catch (SQLException e) {
            System.out.println("Error mencari anggota: " + e.getMessage());
        }
        return hasil;
    }
} 