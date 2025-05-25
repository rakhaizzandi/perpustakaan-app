package src;
import java.sql.Connection;
import src.Koneksi;

public abstract class BaseDAO {
    protected Connection koneksi;
    
    public BaseDAO() {
        this.koneksi = Koneksi.getKoneksi();
    }
    
    protected abstract String getTableName();
    protected abstract String getPrimaryKey();
} 