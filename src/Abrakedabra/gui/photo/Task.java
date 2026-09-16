package Abrakedabra.gui.photo;

import gui.BorderLayoutExample;

import javax.swing.*;
import java.awt.*;

public class Task extends JFrame {
    public Task(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setTitle("task");

        setLayout(new BorderLayout());

        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel centre = new JPanel();
        JPanel east = new JPanel();

        south.setLayout(new FlowLayout(FlowLayout.RIGHT));

        east.setLayout(new GridLayout(5, 1));
        east.setPreferredSize(new Dimension(200, 500));

        north.setLayout(new FlowLayout(FlowLayout.LEFT));
        north.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        centre.setLayout(new GridLayout(10, 11, 10, 10));


        add(north, BorderLayout.NORTH);
        add(centre, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.WEST);


        JTextField text = new JTextField();
        text.setPreferredSize(new Dimension(200, 20));

        north.add(new JLabel("Query:"));
        north.add(text);
        north.add(new JButton("Go"));


        for (int i = 1; i <= 110; i++) {
            centre.add(new Tile("Tile" + i));
        }

        JRadioButton radioA = new JRadioButton("option A");
        JRadioButton radioB = new JRadioButton("option B");
        JRadioButton radioC = new JRadioButton("option C");
        JRadioButton radioD = new JRadioButton("option D");
        JRadioButton radioE = new JRadioButton("option E");

        ButtonGroup group = new ButtonGroup();

        group.add(radioA);
        group.add(radioB);
        group.add(radioC);
        group.add(radioD);
        group.add(radioE);

        east.add(radioA);
        east.add(radioB);
        east.add(radioC);
        east.add(radioD);
        east.add(radioE);

        south.add(new JLabel("110 results"));

    }


    public static void main(String[] args) {
        new Task().setVisible(true);
    }
}

class Tile extends JButton{
    public Tile(String name){
        setText(name);
        setSize(150, 120);
        setBackground(Color.white);
    }
}
