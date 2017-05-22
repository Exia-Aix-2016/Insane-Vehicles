package fr.exia.insanevehicles.first;

import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {
    private String text;

    public void paintComponent(Graphics g){
        Font font = new Font("Consolas",Font.BOLD, 20);
        g.setFont(font);
        drawString(g, text, 10, 20);
    }

    void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
