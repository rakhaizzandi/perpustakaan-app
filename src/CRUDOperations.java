package src;
import java.util.List;

public interface CRUDOperations<T> {
    boolean create(T obj);
    List<T> read();
    boolean update(T obj);
    boolean delete(int id);
    List<T> search(String keyword);
} 