package Abrakedabra.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieTable extends JFrame {
    List<Record> data;

    MovieTable(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(420, 640);

        String[] columnsNames = {"Name", "Year", "Duration", "Rating"};
        DefaultTableModel model = new DefaultTableModel(columnsNames, 0);

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
    }

    void loadData(String filePath){
        try {
            data = Files.lines(Path.of(filePath))
                    .map(line -> line.split(";"))
                    .map(parts -> new Record(
                            parts[0],
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            Double.parseDouble(parts[3])
                    )).toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MovieTable mainWindow = new MovieTable();

        mainWindow.setVisible(true);
    }
}

class Record{
    String name;
    int yearOfRelease;
    int duration;
    Double rating;

    public Record(String name, int yearOfRelease, int duration, Double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.duration = duration;
        this.rating = rating;
    }
}
