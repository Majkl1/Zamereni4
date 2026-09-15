package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class Texting extends JFrame {
    public Texting (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setSize(600, 200);

        setLayout(new FlowLayout());

        JTextField textField = new JTextField("19");
        //textField.setSize(300, 70);
        textField.setPreferredSize(new Dimension(300, 70));
        textField.setFont(new Font("Calibri", Font.PLAIN, 34));
        //textField.setBackground(Color.YELLOW);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        //textField.setEnabled(false);

        JButton button = new JButton("Print");
        button.setSize(140, 70);

        button.addActionListener(e -> {
            try {
                int x = Integer.parseInt(textField.getText());
                new GridPane(x).setVisible(true);
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,
                        "Nedávej tam písmena!!!!",
                    "poslední varování",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        add(textField);
        add(button);
        pack();

    }

    public static void main(String[] args) {
        new Texting().setVisible(true);
    }
}
