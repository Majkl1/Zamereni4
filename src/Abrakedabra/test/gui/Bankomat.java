package Abrakedabra.test.gui;

import Abrakedabra.gui.GridPane;

import javax.swing.*;
import java.awt.*;

public class Bankomat extends JFrame {
    public Bankomat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 150);
        setLayout(new FlowLayout());

        JTextField input = new JTextField("Value");
        input.setPreferredSize(new Dimension(300, 100));

        JButton button = new JButton("Go");
        button.setPreferredSize(new Dimension(100, 100));
        button.addActionListener(a -> {
            try {
                int x = Integer.parseInt(input.getText());
                new Calculator(x, input.getText()).setVisible(true);
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,
                        "zadejte cislo",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(input);
        add(button);

    }

    public static void main(String[] args) {
        new Bankomat().setVisible(true);
    }
}

class Calculator extends JFrame{
    public Calculator(int value, String text){
        setSize(500, 1000);
        setLayout(new BorderLayout());

        JLabel input = new JLabel();
        input.setPreferredSize(new Dimension(50, 300));
        input.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        input.setHorizontalAlignment(SwingConstants.CENTER);
        input.setText(text);
        input.setFont(new Font("Consolas", Font.BOLD, 50));



        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,4,5,5));

        for (int i = 0; i < 12; i++) {
            Tile t = new Tile();

            JLabel label1 = new JLabel();
            JLabel label2 = new JLabel();

            label1.setFont(new Font("Consolas", Font.PLAIN, 15));
            label2.setFont(new Font("Consolas", Font.PLAIN, 15));

            label1.setPreferredSize(new Dimension(50, 50));
            label2.setPreferredSize(new Dimension(50, 50));

            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label2.setHorizontalAlignment(SwingConstants.CENTER);


            label1.setBorder(BorderFactory.createLineBorder(Color.black,1));
            label2.setBorder(BorderFactory.createLineBorder(Color.black,1));

            t.setBackground(Color.red);

            if (i == 0) {
                int j = 0;
                while (value - 5000 >= 0){
                    j++;
                    value = value - 5000;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("5000");
            } else if (i == 1) {
                int j = 0;
                while (value - 2000 >= 0){
                    j++;
                    value = value - 2000;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("2000");
            } else if (i == 2) {
                int j = 0;
                while (value - 1000 >= 0){
                    j++;
                    value = value - 1000;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("1000");
            } else if (i == 3) {
                int j = 0;
                while (value - 500 >= 0){
                    j++;
                    value = value - 500;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("500");
            } else if (i == 4) {
                int j = 0;
                while (value - 200 >= 0){
                    j++;
                    value = value - 200;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("200");
            } else if (i == 5) {
                int j = 0;
                while (value - 100 >= 0){
                    j++;
                    value = value - 100;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("100");
            } else if (i == 6) {
                int j = 0;
                while (value - 50 >= 0){
                    j++;
                    value = value - 50;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("50");
            } else if (i == 7) {
                int j = 0;
                while (value - 20 >= 0){
                    j++;
                    value = value - 20;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("20");
            } else if (i == 8) {
                int j = 0;
                while (value - 10 >= 0){
                    j++;
                    value = value - 10;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("10");
            }else if (i == 9) {
                int j = 0;
                while (value - 5 >= 0){
                    j++;
                    value = value - 5;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("5");
            } else if (i == 10) {
                int j = 0;
                while (value - 2 >= 0){
                    j++;
                    value = value - 2;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("2");
            } else if (i == 11) {
                int j = 0;
                while (value - 1 >= 0){
                    j++;
                    value = value - 1;
                    t.setBackground(Color.green);
                }
                label1.setText(j + "x");
                label2.setText("1");
            }
            t.add(label1,BorderLayout.NORTH);
            t.add(label2, BorderLayout.CENTER);
            panel.add(t);

        }

        add(input, BorderLayout.NORTH);
        add(panel);

    }
}

class Tile extends JPanel{
    public Tile(){
        setLayout(new BorderLayout());

    }
}
