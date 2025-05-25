package src;
import src.BaseModel;

public class Anggota extends BaseModel {
    private String alamat;
    private String noTelp;
    private String email;
    private String status;

    // Default constructor
    public Anggota() {
        super();
    }

    // Overloaded constructor 1
    public Anggota(String nama, String email) {
        super(0, nama);
        this.email = email;
    }

    // Overloaded constructor 2
    public Anggota(int idAnggota, String nama, String alamat, String noTelp, String email, String status) {
        super(idAnggota, nama);
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.email = email;
        this.status = status;
    }

    // Getters and Setters
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Method overloading untuk update status
    public void updateStatus(String status) {
        this.status = status;
    }

    public void updateStatus(String status, String keterangan) {
        this.status = status;
        System.out.println("Status diupdate: " + keterangan);
    }

    @Override
    public void displayInfo() {
        System.out.println("Anggota: " + getNama());
        System.out.println("Email: " + email);
        System.out.println("No. Telp: " + noTelp);
        System.out.println("Status: " + status);
    }
} 