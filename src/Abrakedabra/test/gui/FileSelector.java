package Abrakedabra.test.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class FileSelector {
    public static void main(String[] args) {
        new FilePicker().setVisible(true);
    }
}


class FilePicker extends JFrame{
    File file;


    void load(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showOpenDialog(null);

        if (!chooser.getSelectedFile().exists()){
            JOptionPane.showMessageDialog(null,
                    "Soubor neexistuje",
                    "error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        file = chooser.getSelectedFile();

    }


    public FilePicker(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 200);
        setTitle("File statistics");
        setLayout(new BorderLayout());

        JTextField text = new JTextField();
        text.setPreferredSize(new Dimension(100, 40));
        text.setEditable(false);

        add(text,BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        add(panel, BorderLayout.CENTER);

        JButton load = new JButton("Load File");
        load.setPreferredSize(new Dimension(200, 50));

        load.addActionListener(a ->{
            load();
            text.setText(file.getAbsolutePath());

        });


        panel.add(load);

        JButton show = new JButton("Show statistics");
        show.setPreferredSize(new Dimension(200, 50));

        show.addActionListener(a -> {
            if (file.exists()){
                new Statistics(file).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Vyber soubor",
                        "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(show);

    }
}

class Statistics extends JFrame {
    File file;

    final String[] stats = {"Název:",
            "Typ:",
            "Cesta:",
            "Počet souborů:",
            "Počet podsložek:",
            "Celková velikost souborů:",
            "Největší soubor:",
            "Velikost největšího souboru:"};

    ArrayList<String> contents = new ArrayList<>();



    void loadContents(){
        contents.add(file.getName());

        if (file.isDirectory()){
            contents.add("Složka");
        } else {
            contents.add("Soubor");
        }

        File[] files = file.listFiles();

        int fil = 0;
        int dir = 0;
        File biggest = files[0];
        for (File f : files){
            if (f.isDirectory()){
                dir++;
            } else {
                fil++;
            }
            if (f.length() > biggest.length()){
                biggest = f;
            }
        }



        contents.add(file.getAbsolutePath());
        contents.add(String.valueOf(fil));
        contents.add(String.valueOf(dir));
        contents.add((file.length()/(1024*1024)) + " MB");
        contents.add(biggest.getName());
        contents.add((biggest.length()/(1024*1024)) + "MB");
    }


    public Statistics(File fil){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 1000);
        setTitle("Statistics");
        setLayout(new GridLayout(8, 1));

        file = fil;
        loadContents();


        for (int i = 0; i < stats.length; i++) {
            InfoTile tile = new InfoTile(stats[i], contents.get(i));

            add(tile);
        }

    }
}

class InfoTile extends JPanel{
    public InfoTile(String name, String text){
        setLayout(new FlowLayout());

        JLabel label1 = new JLabel();
        label1.setPreferredSize(new Dimension(250, 50));
        label1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        label1.setText(name);

        JLabel label2 = new JLabel();
        label2.setPreferredSize(new Dimension(250, 50));
        label2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        label2.setText(text);

        add(label1);
        add(label2);

    }
}

