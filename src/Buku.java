package src;
import src.Item;

public class Buku extends Item {
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
    private String isbn;
    private int stok;
    private int idKategori;
    private String namaKategori;

    // Default constructor
    public Buku() {
        super();
    }

    // Overloaded constructor 1
    public Buku(String judul, String pengarang) {
        super();
        this.judul = judul;
        this.pengarang = pengarang;
    }

    // Overloaded constructor 2
    public Buku(int idBuku, String judul, String pengarang, String penerbit, 
                int tahunTerbit, String isbn, int stok, int idKategori) {
        super(idBuku, judul);
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.isbn = isbn;
        this.stok = stok;
        this.idKategori = idKategori;
    }

    // Getter dan Setter id khusus Buku
    public int getIdBuku() { return getId(); }
    public void setIdBuku(int idBuku) { setId(idBuku); }

    // Getters and Setters
    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getPengarang() { return pengarang; }
    public void setPengarang(String pengarang) { this.pengarang = pengarang; }

    public String getPenerbit() { return penerbit; }
    public void setPenerbit(String penerbit) { this.penerbit = penerbit; }

    public int getTahunTerbit() { return tahunTerbit; }
    public void setTahunTerbit(int tahunTerbit) { this.tahunTerbit = tahunTerbit; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public int getIdKategori() { return idKategori; }
    public void setIdKategori(int idKategori) { this.idKategori = idKategori; }

    public String getNamaKategori() { return namaKategori; }
    public void setNamaKategori(String namaKategori) { this.namaKategori = namaKategori; }

    // Method overloading untuk update stok
    public void updateStok(int stok) {
        this.stok = stok;
    }

    public void updateStok(int stok, String keterangan) {
        this.stok = stok;
        System.out.println("Stok diupdate: " + keterangan);
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku: " + judul + " oleh " + pengarang);
    }
} 