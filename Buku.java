public class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
    private String isbn;
    private int stok;
    private int idKategori;
    private String namaKategori;

    // Constructor
    public Buku() {}

    public Buku(int idBuku, String judul, String pengarang, String penerbit, 
                int tahunTerbit, String isbn, int stok, int idKategori) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.isbn = isbn;
        this.stok = stok;
        this.idKategori = idKategori;
    }

    // Getters and Setters
    public int getIdBuku() { return idBuku; }
    public void setIdBuku(int idBuku) { this.idBuku = idBuku; }

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
} 