package Model.Mahasiswa;
import java.util.List;

public interface InterfaceDAOMahasiswa {
    void insert(Mahasiswa m);
    void update(Mahasiswa m);
    void delete(int id);
    List<Mahasiswa> getAll();
}
