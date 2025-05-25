package src;

public abstract class BaseModel {
    protected int id;
    protected String nama;
    
    public BaseModel() {}
    
    public BaseModel(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public abstract void displayInfo();
} 