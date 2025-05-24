package Main;

import View.Mahasiswa.InputData;
import View.Mahasiswa.ViewData;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame menu = new JFrame("Menu Mahasiswa");
        JButton btnInput = new JButton("Input Mahasiswa");
        JButton btnView = new JButton("Lihat Mahasiswa");

        menu.setSize(300, 150);
        menu.setLayout(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnInput.setBounds(50, 20, 200, 30);
        btnView.setBounds(50, 60, 200, 30);

        menu.add(btnInput); menu.add(btnView);

        btnInput.addActionListener(e -> new InputData());
        btnView.addActionListener(e -> new ViewData());

        menu.setVisible(true);
    }
}
