package Abrakedabra.gui.caryMary;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TimeMachine {
    public static void main(String[] args) {
        new Input().setVisible(true);
    }
}

class Input extends JFrame {
    public Input(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Prevodnik casu");
        setSize(1000, 200);
        setLayout(new FlowLayout());

        JTextField inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(700, 150));
        inputField.setFont(new Font("Consolas", Font.PLAIN, 20));
        inputField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button = new JButton("Prevod");
        button.setPreferredSize(new Dimension(200, 150));

        button.addActionListener(a -> {
            boolean isDigit = true;
            for (char ch : inputField.getText().toCharArray()){
                if (!Character.isDigit(ch)){
                    isDigit = false;
                    break;
                }
            }
            if (isDigit){
                new Calculator(Integer.parseInt(inputField.getText())).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Zadej cislo", "Chyba", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(inputField);
        add(button);

    }
}

class Calculator extends JFrame{

    static final Map<Integer, Integer> TIME = Map.of(
            0, 86400,
            1, 3600,
            2, 60,
            3, 1);

    static final Map<Integer, String> TIME2 = Map.of(
            86400, "dny",
            3600, "hod",
            60, "min",
            1, "sec");


    public Calculator(int input){

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Vysledek");
        setSize(800, 500);
        setLayout(new BorderLayout());

        JLabel display = new JLabel(String.valueOf(input));
        display.setPreferredSize(new Dimension(750, 100));
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.setFont(new Font("Consolas", Font.BOLD, 30));
        display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(2, 2, 3, 3));

        for (int i = 0; i < TIME.size(); i++) {
            int count = 0;
            while (input >= TIME.get(i)){
                input -= TIME.get(i);
                count++;
            }
            grid.add(new TimeTile(count, TIME2.get(TIME.get(i))));
            System.out.println("tile" + i);
        }


        add(display, BorderLayout.NORTH);
        add(grid, BorderLayout.CENTER);


    }
}

class TimeTile extends JLabel {
    public TimeTile(int count, String type){
        setPreferredSize(new Dimension(250, 100));
        setHorizontalAlignment(CENTER);
        setFont(new Font("Consolas", Font.BOLD, 20));
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        setOpaque(true);

        setText(count + "x \n" + type);

        if (count > 0){
            setBackground(Color.green);
        } else {
            setBackground(Color.red);
        }

    }

}
