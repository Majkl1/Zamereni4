package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class Listing extends JFrame {

    public Listing(){
        setTitle("listDemo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Java");
        model.addElement("Python");
        model.addElement("C#");
        model.addElement("PHP");
        model.addElement("Rust");
        model.addElement("GO");

        JList<String> languageList = new JList<>(model);
        languageList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        languageList.setLayoutOrientation(JList.VERTICAL);
        languageList.setVisibleRowCount(6);

        JScrollPane scrollPane = new JScrollPane(languageList);

        add(scrollPane, BorderLayout.CENTER);

        languageList.addListSelectionListener(e -> {
            System.out.println(languageList.getSelectedIndex());
            System.out.println(languageList.getSelectedValue());
        });

    }

    public static void main(String[] args) {
        new Listing().setVisible(true);
    }
}
