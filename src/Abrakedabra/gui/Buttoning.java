package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttoning extends JFrame {

    public Buttoning(){
        final Font MY_FONT = new Font("Consolas", Font.BOLD, 24);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640,640);
        setLocationRelativeTo(null);

        JButton hideButton = new JButton("Hide");

        hideButton.setFont(MY_FONT);
        hideButton.setFocusable(false);
        hideButton.setBackground(Color.cyan);
        hideButton.setForeground(new Color(94, 0, 128));
        //new Color(0x00ff00)

        JButton showButton = new JButton("Show");
        showButton.setFont(MY_FONT);
        showButton.setFocusable(false); //dá se na něj najet tabem
        showButton.setBackground(Color.cyan);
        showButton.setForeground(new Color(94, 0, 128));


        JLabel label = new JLabel("nejaky text");

        label.setFont(MY_FONT);
        label.setBackground(Color.white);
        label.setForeground(Color.black);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);


        setLayout(null); //musím použýívat x, y souřadnice

        hideButton.setBounds(200, 0, 240, 100);
        showButton.setBounds(200, 105, 240, 100);
        label.setBounds(200, 300, 240,100);

        //akce tlacitek
        hideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
                label.setBackground(Color.black);
                showButton.setEnabled(true);
                hideButton.setEnabled(false);
            }
        });

        showButton.addActionListener(a -> {
            label.setBackground(Color.white);
            showButton.setEnabled(false);
            hideButton.setEnabled(true);
        });

        add(label);
        add(hideButton);
        add(showButton);

    }

    public static void main(String[] args) {
        new Buttoning().setVisible(true);
    }
}
