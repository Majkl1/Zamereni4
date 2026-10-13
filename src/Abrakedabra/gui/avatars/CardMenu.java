package Abrakedabra.gui.avatars;

import javax.swing.*;
import java.awt.*;

public class CardMenu extends JFrame {
    JLabel fullName, salary, shoeSize;
    ImageIcon avatar;
    JPanel lowerMenu;
    JButton next, previous, first, last;

    int current = 0;

    CardMenu(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,400);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        lowerMenu = new JPanel();
        lowerMenu.setLayout(new FlowLayout());


        fullName = new JLabel();
        salary = new JLabel();
        shoeSize = new JLabel();

        fullName.setFont(new Font("MV Boli", Font.BOLD, 18));
        salary.setFont(new Font("MV Boli", Font.BOLD, 18));
        shoeSize.setFont(new Font("MV Boli", Font.BOLD, 18));

//        avatar = MainMenu.personData.get(0).avatar;//zaciname na prvnim
        showAvatar(0);

        fullName.setIcon(avatar);
        fullName.setHorizontalTextPosition(JLabel.CENTER);
        fullName.setVerticalTextPosition(JLabel.TOP);
        fullName.setIconTextGap(5);
        fullName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        this.add(fullName, BorderLayout.CENTER);

        previous = new JButton("Previous");
        next = new JButton("Next");
        first = new JButton("First");
        last = new JButton("Last");



        // TODO
        previous.addActionListener(e -> {
            showPrevious();
        });
        next.addActionListener(e -> {
            showNext();
        });
        first.addActionListener(e -> {
            current = 0;
            showAvatar(current);
        });
        last.addActionListener(e -> {
            current = MainMenu.personData.size()-1;
            showAvatar(current);
        });

        lowerMenu.add(first);
        lowerMenu.add(previous);
        lowerMenu.add(shoeSize);
        lowerMenu.add(salary);
        lowerMenu.add(next);
        lowerMenu.add(last);

        this.add(lowerMenu, BorderLayout.SOUTH);
        this.pack();
    }

    private void showNext() {
        if (current == MainMenu.personData.size()-1){
            current = 0;
            showAvatar(current);
        } else {
            showAvatar(++current);
        }

    }

    private void showPrevious() {
        if (current == 0){
            current = MainMenu.personData.size()-1;
            showAvatar(current);
        } else {
            showAvatar(--current);
        }
    }

    void showAvatar(int index){
        avatar = new ImageIcon(MainMenu.personData.get(index).avatar.getImage().getScaledInstance(500,450, Image.SCALE_DEFAULT));
        fullName.setIcon(avatar);
        fullName.setText("Full name: " + MainMenu.personData.get(index).name + " " + MainMenu.personData.get(index).surname);
        shoeSize.setText("Shoe size: " + MainMenu.personData.get(index).shoeSize);
        salary.setText("Salary: " + MainMenu.personData.get(index).salary);
    }

}
