package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Main.Main;
import javax.swing.*;
import java.awt.event.*;

public class InputData extends JFrame {
    JLabel lNama = new JLabel("Nama:");
    JLabel lNim = new JLabel("NIM:");
    JTextField tfNama = new JTextField();
    JTextField tfNim = new JTextField();
    JButton btnSimpan = new JButton("Simpan");
    JButton btnKembali = new JButton("Kembali");

    ControllerMahasiswa controller = new ControllerMahasiswa();

    public InputData() {
        setTitle("Input Mahasiswa");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lNama.setBounds(20, 20, 80, 25);
        tfNama.setBounds(100, 20, 150, 25);
        lNim.setBounds(20, 60, 80, 25);
        tfNim.setBounds(100, 60, 150, 25);
        btnSimpan.setBounds(50, 100, 100, 30);
        btnKembali.setBounds(160, 100, 100, 30);

        add(lNama); add(tfNama);
        add(lNim); add(tfNim);
        add(btnSimpan); add(btnKembali);

        // Action Listener untuk tombol Simpan
        btnSimpan.addActionListener((ActionEvent e) -> {
            if (tfNama.getText().isEmpty() || tfNim.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama dan NIM tidak boleh kosong!");
                return;
            }
            
            controller.tambahData(tfNama.getText(), tfNim.getText());
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            
            // Kembali ke menu utama setelah simpan
            dispose();
            new Main();
        });

        // Action Listener untuk tombol Kembali
        btnKembali.addActionListener((ActionEvent e) -> {
            dispose();
            new Main();
        });

        setVisible(true);
    }
}