package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class Radio extends JFrame {

    public Radio(){
        setSize(500, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new FlowLayout()), centerPanel = new JPanel();

        JRadioButton rbRed = new JRadioButton("Red");
        JRadioButton rbGreen = new JRadioButton("Green");
        JRadioButton rbBlue = new JRadioButton("Blue");

        rbRed.setBackground(Color.red);
        rbGreen.setBackground(Color.green);
        rbBlue.setBackground(Color.blue);

        JCheckBox cbBorder = new JCheckBox("Border");

        ButtonGroup group = new ButtonGroup();

        JButton button = new JButton("Paint");
        button.addActionListener(e -> {
           if(rbRed.isSelected()){
               centerPanel.setBackground(Color.red);
           } else if (rbBlue.isSelected()) {
               centerPanel.setBackground(Color.blue);
           } else if (rbGreen.isSelected()) {
               centerPanel.setBackground(Color.green);
           }
           if (cbBorder.isSelected()){
               centerPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 10));
           } else {
               centerPanel.setBorder(null);
           }

        });

        northPanel.add(rbRed);
        northPanel.add(rbGreen);
        northPanel.add(rbBlue);
        northPanel.add(cbBorder);
        northPanel.add(button);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        group.add(rbRed);
        group.add(rbGreen);
        group.add(rbBlue);




    }


    public static void main(String[] args) {
        new Radio().setVisible(true);
    }
}
