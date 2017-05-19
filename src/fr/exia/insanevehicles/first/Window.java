package fr.exia.insanevehicles.first;

import javax.swing.*;

class Window extends JFrame {
    Window(){
        this.setTitle("Ma première fenêtre Java");
        this.setSize(200, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
