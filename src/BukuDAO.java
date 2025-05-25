package src;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.BaseDAO;
import src.Buku;

public class BukuDAO extends BaseDAO implements CRUDOperations<Buku> {
    
    public BukuDAO() {
        super();
    }

    @Override
    protected String getTableName() {
        return "buku";
    }

    @Override
    protected String getPrimaryKey() {
        return "id_buku";
    }

    @Override
    public boolean create(Buku buku) {
        String sql = "INSERT INTO buku (judul, pengarang, penerbit, tahun_terbit, isbn, stok, id_kategori) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPengarang());
            ps.setString(3, buku.getPenerbit());
            ps.setInt(4, buku.getTahunTerbit());
            ps.setString(5, buku.getIsbn());
            ps.setInt(6, buku.getStok());
            ps.setInt(7, buku.getIdKategori());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error menambah buku: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Buku> read() {
        List<Buku> daftarBuku = new ArrayList<>();
        String sql = "SELECT b.*, k.nama_kategori FROM buku b " +
                    "LEFT JOIN kategori k ON b.id_kategori = k.id_kategori";
        try (Statement stmt = koneksi.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Buku buku = new Buku();
                buku.setId(rs.getInt("id_buku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPengarang(rs.getString("pengarang"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                buku.setIsbn(rs.getString("isbn"));
                buku.setStok(rs.getInt("stok"));
                buku.setIdKategori(rs.getInt("id_kategori"));
                buku.setNamaKategori(rs.getString("nama_kategori"));
                daftarBuku.add(buku);
            }
        } catch (SQLException e) {
            System.out.println("Error mengambil data buku: " + e.getMessage());
        }
        return daftarBuku;
    }

    @Override
    public boolean update(Buku buku) {
        String sql = "UPDATE buku SET judul=?, pengarang=?, penerbit=?, " +
                    "tahun_terbit=?, isbn=?, stok=?, id_kategori=? WHERE id_buku=?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getPengarang());
            ps.setString(3, buku.getPenerbit());
            ps.setInt(4, buku.getTahunTerbit());
            ps.setString(5, buku.getIsbn());
            ps.setInt(6, buku.getStok());
            ps.setInt(7, buku.getIdKategori());
            ps.setInt(8, buku.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error update buku: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM buku WHERE id_buku=?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error hapus buku: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Buku> search(String keyword) {
        List<Buku> hasil = new ArrayList<>();
        String sql = "SELECT b.*, k.nama_kategori FROM buku b " +
                    "LEFT JOIN kategori k ON b.id_kategori = k.id_kategori " +
                    "WHERE b.judul LIKE ? OR b.pengarang LIKE ? OR b.penerbit LIKE ?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ps.setString(3, searchPattern);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Buku buku = new Buku();
                buku.setId(rs.getInt("id_buku"));
                buku.setJudul(rs.getString("judul"));
                buku.setPengarang(rs.getString("pengarang"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahunTerbit(rs.getInt("tahun_terbit"));
                buku.setIsbn(rs.getString("isbn"));
                buku.setStok(rs.getInt("stok"));
                buku.setIdKategori(rs.getInt("id_kategori"));
                buku.setNamaKategori(rs.getString("nama_kategori"));
                hasil.add(buku);
            }
        } catch (SQLException e) {
            System.out.println("Error mencari buku: " + e.getMessage());
        }
        return hasil;
    }
} 