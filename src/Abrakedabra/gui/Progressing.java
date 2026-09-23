package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class Progressing extends JFrame {
    JProgressBar bar;

    public Progressing(){
        setSize(420, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        bar = new JProgressBar();
        bar.setFont(new Font("Consolas", Font.BOLD, 28));


        bar.setBounds(0,0, getWidth(), 60);
        bar.setStringPainted(true);
        bar.setValue(100);
        bar.setForeground(Color.magenta);
        bar.setBackground(new Color(0xFF8941));


        add(bar);
    }

    public void fill(){
        int counter = 100;

        while(counter <= 100){
            try {
                Thread.sleep(86);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter--;
            bar.setValue(counter);
        }

    }

    public static void main(String[] args) {
        Progressing p = new Progressing();
        p.setVisible(true);
        p.fill();
    }
}
