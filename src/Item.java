package src;

public abstract class Item {
    protected int id;
    protected String nama;
    
    public Item() {}
    public Item(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public abstract void displayInfo();
} 