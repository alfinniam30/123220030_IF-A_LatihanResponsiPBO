package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Model.Mahasiswa.Mahasiswa;
import Main.Main;  // Import class Main dari package yang benar

import javax.swing.*;
import java.awt.event.*;

public class ViewData extends JFrame {
    JTable table = new JTable();
    JScrollPane scroll = new JScrollPane(table);
    JButton btnRefresh = new JButton("Refresh");
    JButton btnHapus = new JButton("Hapus");
    JButton btnEdit = new JButton("Edit");
    JButton btnKembali = new JButton("Kembali");

    ControllerMahasiswa controller = new ControllerMahasiswa();

    public ViewData() {
        setTitle("Data Mahasiswa");
        setSize(560, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        scroll.setBounds(20, 20, 520, 250);
        btnRefresh.setBounds(20, 290, 100, 30);
        btnHapus.setBounds(130, 290, 100, 30);
        btnEdit.setBounds(240, 290, 100, 30);
        btnKembali.setBounds(350, 290, 100, 30);

        add(scroll);
        add(btnRefresh);
        add(btnHapus);
        add(btnEdit);
        add(btnKembali);

        controller.tampilData(table);

        btnRefresh.addActionListener(e -> controller.tampilData(table));

        btnHapus.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int confirm = JOptionPane.showConfirmDialog(
                    null, 
                    "Yakin ingin menghapus data ini?", 
                    "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION
                );
                
                if (confirm == JOptionPane.YES_OPTION) {
                    int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                    controller.hapusData(id);
                    controller.tampilData(table);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus!");
            }
        });

        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int id = Integer.parseInt(table.getValueAt(row, 0).toString());
                String nama = table.getValueAt(row, 1).toString();
                String nim = table.getValueAt(row, 2).toString();
                
                Mahasiswa mhs = new Mahasiswa(id, nama, nim);
                dispose();
                new EditData(mhs);
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data yang akan diedit!");
            }
        });

        btnKembali.addActionListener(e -> {
            dispose();
            new Main(); // Sekarang sudah bisa mengenali class Main
        });

        setVisible(true);
    }
}