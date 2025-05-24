package Controller;

import Model.Mahasiswa.DAOMahasiswa;
import Model.Mahasiswa.Mahasiswa;
import javax.swing.*;
import java.util.List;

public class ControllerMahasiswa {
    DAOMahasiswa dao = new DAOMahasiswa();

    public void tampilData(JTable table) {
        List<Mahasiswa> list = dao.getAll();
        String[] kolom = {"ID", "Nama", "NIM"};
        String[][] data = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = String.valueOf(list.get(i).getId());
            data[i][1] = list.get(i).getNama();
            data[i][2] = list.get(i).getNim();
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, kolom));
    }

    public void tambahData(String nama, String nim) {
        Mahasiswa m = new Mahasiswa(0, nama, nim);
        dao.insert(m);
    }

    public void ubahData(int id, String nama, String nim) {
        Mahasiswa m = new Mahasiswa(id, nama, nim);
        dao.update(m);
    }

    // ✅ Tambahkan method ini
    public void editMahasiswa(int id, String nama, String nim) {
        ubahData(id, nama, nim);
    }

    public void hapusData(int id) {
        dao.delete(id);
    }
}
