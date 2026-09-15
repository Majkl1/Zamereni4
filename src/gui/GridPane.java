package gui;

import javax.swing.*;
import java.awt.*;

public class GridPane extends JFrame {
    public GridPane(){
        int dimension = 18; //(4-100)

        setSize(700, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(dimension,dimension));

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
            if ((i+j) % 2 == 1)
                add(new Piece(Color.red));
            else
                add(new Piece(Color.cyan));
            }
        }
    }


    public static void main(String[] args) {
        new GridPane().setVisible(true);
    }
}
class Piece extends JLabel {

    //vlastni label, pamatuje si vsechnu konfiguraci
    public Piece(Color color){
        setText(" ");
        setFont(new Font("Arial", Font.PLAIN, 18));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setOpaque(true);
        setBackground(color);
    }
}
