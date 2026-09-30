package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class Sliding extends JFrame {
    public Sliding(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(420, 420);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JSlider slider = new JSlider(SwingConstants.VERTICAL, -100, 100, 21);

        slider.addChangeListener(e -> {
            label.setText("°C = " + slider.getValue());
        });

        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPaintTrack(true);

        slider.setForeground(Color.blue);
        slider.setBackground(Color.green);


        label.setText("°C = " + slider.getValue());
        label.setFont(new Font("Roboto", Font.BOLD, 21));

        panel.add(slider);
        panel.add(label);

        add(panel);


    }

    public static void main(String[] args) {
        new Sliding().setVisible(true);
    }

}
