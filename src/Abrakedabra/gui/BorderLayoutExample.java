package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutExample extends JFrame {
    public BorderLayoutExample(){
        //settings
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        //layout
        setLayout(new BorderLayout());


        JPanel redPanel = new JPanel();
        redPanel.setPreferredSize(new Dimension(100,100));
        redPanel.setBackground(Color.red);

        JPanel bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(100,100));
        bluePanel.setBackground(Color.blue);

        JPanel greenPanel = new JPanel();
        greenPanel.setPreferredSize(new Dimension(100,100));
        greenPanel.setBackground(Color.green);

        JPanel yellowPanel = new JPanel();
        yellowPanel.setPreferredSize(new Dimension(100,100));
        yellowPanel.setBackground(Color.yellow);


        //add
        add(redPanel, BorderLayout.NORTH);
        add(bluePanel, BorderLayout.SOUTH);
        add(greenPanel, BorderLayout.WEST);
        add(yellowPanel, BorderLayout.EAST);

        JPanel innerPanel = new JPanel();
        innerPanel.setPreferredSize(new Dimension(100,100));
        innerPanel.setLayout(new BorderLayout());


        JPanel redPanel2 = new JPanel();
        redPanel2.setPreferredSize(new Dimension(100,100));
        redPanel2.setBackground(Color.black);

        JPanel bluePanel2 = new JPanel();
        bluePanel2.setPreferredSize(new Dimension(100,100));
        bluePanel2.setBackground(Color.gray);

        JPanel greenPanel2 = new JPanel();
        greenPanel2.setPreferredSize(new Dimension(100,100));
        greenPanel2.setBackground(Color.magenta);

        JPanel yellowPanel2 = new JPanel();
        yellowPanel2.setPreferredSize(new Dimension(100,100));
        yellowPanel2.setBackground(Color.pink);


        JButton tocky = new JButton("Točky!!!!");
        tocky.addActionListener(a -> {
            Color help = yellowPanel2.getBackground();
            yellowPanel2.setBackground(bluePanel2.getBackground());
            bluePanel2.setBackground(greenPanel2.getBackground());
            greenPanel2.setBackground(redPanel2.getBackground());
            redPanel2.setBackground(greenPanel.getBackground());
            greenPanel.setBackground(bluePanel.getBackground());
            bluePanel.setBackground(yellowPanel.getBackground());
            yellowPanel.setBackground(redPanel.getBackground());
            redPanel.setBackground(help);





            //inner circle:




        });

        add(innerPanel, BorderLayout.CENTER);

        innerPanel.add(redPanel2, BorderLayout.NORTH);
        innerPanel.add(yellowPanel2, BorderLayout.EAST);
        innerPanel.add(bluePanel2, BorderLayout.SOUTH);
        innerPanel.add(greenPanel2, BorderLayout.WEST);

        innerPanel.add(tocky, BorderLayout.CENTER);

    }




    public static void main(String[] args) {
        new BorderLayoutExample().setVisible(true);
    }
}
