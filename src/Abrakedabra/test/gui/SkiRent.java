package Abrakedabra.test.gui;

import javax.swing.*;
import java.awt.*;

public class SkiRent extends JFrame {
    final static Font LABEL_FONT = new Font("Calibri", Font.BOLD, 15);


    public SkiRent(){
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Ski Rental");

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Mountain Equipment Rental");
        title.setFont(new Font("Calibri", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(title, BorderLayout.NORTH);


        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.CENTER));


        JButton rent = new JButton("Rent");
        JButton clear = new JButton("Clear");

        south.add(rent);
        south.add(clear);
        add(south, BorderLayout.SOUTH);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5,2, 5, 5));

        //name
        JLabel name = new JLabel("Customer name:");
        name.setFont(LABEL_FONT);

        JTextField nameField = new JTextField();

        center.add(name);
        center.add(nameField);


        //room
        JLabel room = new JLabel("Room number:");
        room.setFont(LABEL_FONT);

        JTextField roomField = new JTextField();

        center.add(room);
        center.add(roomField);


        //equipment
        JLabel equipment = new JLabel("Equipment:");
        equipment.setFont(LABEL_FONT);

        JPanel equipmentButtons = new JPanel(new FlowLayout());

        ButtonGroup group = new ButtonGroup();

        JRadioButton ski = new JRadioButton("Skis");
        JRadioButton snowboard = new JRadioButton("Snowboard");
        JRadioButton cross = new JRadioButton("Cross-country skis");

        ski.setSelected(true);

        group.add(ski);
        group.add(snowboard);
        group.add(cross);

        equipmentButtons.add(ski);
        equipmentButtons.add(snowboard);
        equipmentButtons.add(cross);


        center.add(equipment);
        center.add(equipmentButtons);


        //discount
        JLabel discount = new JLabel("Student discount:");
        discount.setFont(LABEL_FONT);

        JCheckBox discountCheck = new JCheckBox();

        center.add(discount);
        center.add(discountCheck);


        //days
        JLabel days = new JLabel("Rental days:");
        days.setFont(LABEL_FONT);

        JSlider daySlider = new JSlider(1,14, 6);
        daySlider.setMajorTickSpacing(1);
        daySlider.setPaintTrack(true);
        daySlider.setPaintTicks(true);
        daySlider.setPaintLabels(true);

        center.add(days);
        center.add(daySlider);


        add(center, BorderLayout.CENTER);


        ski.addActionListener(e -> {
            discountCheck.setEnabled(true);
            daySlider.setMaximum(14);
        });

        snowboard.addActionListener(e -> {
            discountCheck.setEnabled(true);
            daySlider.setMaximum(14);
        });

        cross.addActionListener(e -> {
            discountCheck.setEnabled(false);
            discountCheck.setSelected(false);
            daySlider.setMaximum(7);
        });


        rent.addActionListener(e -> {
            String wrong = "";
            int roomNumber = 0;

            if (isNumber(roomField.getText())){
                roomNumber = Integer.parseInt(roomField.getText());
                if (roomNumber < 100 || roomNumber > 699){
                    wrong += "Číslo pokoje není v rozmezí mezi 100-699 \n";
                } else {

                }
            } else {
                wrong += "číslo pokoje není číslo \n";
            }

            if (nameField.getText().isEmpty() || roomField.getText().isEmpty()){
                wrong += "Vše není vyplněno \n ";
            }

            if (wrong.isEmpty()){
                JOptionPane.showMessageDialog(null, "OK", "Status", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, wrong, "Status", JOptionPane.ERROR_MESSAGE);
            }

        });

        clear.addActionListener(e -> {
            nameField.setText("");
            roomField.setText("");
            discountCheck.setSelected(false);
            ski.setSelected(true);
            daySlider.setMaximum(14);
        });

    }

    public boolean isNumber(String text){
        boolean number = true;
        if (text.isEmpty()){
            return false;
        }
        for (char a : text.toCharArray()){
            if (!Character.isDigit(a)){
                number = false;
                break;
            }
        }
        if (!number){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        new SkiRent().setVisible(true);
    }
}
