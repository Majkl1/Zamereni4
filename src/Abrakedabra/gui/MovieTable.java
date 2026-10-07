package Abrakedabra.gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieTable extends JFrame {
    List<Record> data;
    DefaultTableModel model;

    MovieTable(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(420, 640);
        setLayout(new BorderLayout());

        JPanel upperPanel = new JPanel(new FlowLayout());

        JRadioButton nameButton = new JRadioButton("Name");
        JRadioButton yearButton = new JRadioButton("Released");
        JRadioButton ratingButton = new JRadioButton("Rating");
        JRadioButton durationButton = new JRadioButton("Duration");

        ButtonGroup group = new ButtonGroup();
        group.add(nameButton);
        group.add(yearButton);
        group.add(ratingButton);
        group.add(durationButton);

        nameButton.setSelected(true);

        nameButton.setFocusable(false);
        yearButton.setFocusable(false);
        ratingButton.setFocusable(false);
        durationButton.setFocusable(false);

        JButton sortButton = new JButton("Sort");
        sortButton.setFocusable(false);

        sortButton.addActionListener(e -> {

            if (nameButton.isSelected()){
                data.sort(Comparator.comparing(Record::getName));
            }
            if (yearButton.isSelected()){
                data.sort(Comparator.comparingInt(Record::getYearOfRelease));
            }
            if (ratingButton.isSelected()){

                //anonymní vnitřní třída
                data.sort(new Comparator<Record>() {
                    @Override
                    public int compare(Record o1, Record o2) {
                        return Double.compare(o1.getRating(), o2.getRating());
                    }
                });
            }
            if (durationButton.isSelected()){
                data.sort(Comparator.comparingInt(Record::getDuration));
            }

            model.setRowCount(0);
            fillTable();
        });


        String[] columnsNames = {"Name", "Year", "Rating", "Duration"};
        model = new DefaultTableModel(columnsNames, 0);

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        loadData("data/Movies.txt");
        fillTable();

        upperPanel.add(nameButton);
        upperPanel.add(yearButton);
        upperPanel.add(ratingButton);
        upperPanel.add(durationButton);
        upperPanel.add(sortButton);

        add(upperPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    void loadData(String filePath){
        try {
            data = new ArrayList<>( Files.lines(Path.of(filePath))
                    .map(line -> line.split(";"))
                    .map(parts -> new Record(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Double.parseDouble(parts[2]),
                            Integer.parseInt(parts[3])
                            )).toList() );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void fillTable(){
        for (Record record : data){
            model.addRow(record.getAsTableRow());
        }
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        MovieTable mainWindow = new MovieTable();
        mainWindow.setVisible(true);
    }
}

class Record{
    String name;
    int yearOfRelease;
    Double rating;
    int duration;

    public Record(String name, int yearOfRelease,Double rating, int duration) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.duration = duration;
    }

    public String[] getAsTableRow(){
        return new String[] {name, String.valueOf(yearOfRelease), String.valueOf(rating), String.valueOf(duration)};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
