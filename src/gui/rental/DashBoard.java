package gui.rental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DashBoard extends JFrame {
    public static ArrayList<Rent> rents = new ArrayList<>();

    // Tabulka
    private JTable table;
    private DefaultTableModel model;

    public DashBoard(){
        setTitle("Dashboard");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // North
        JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Consolas", Font.BOLD, 18));

        // Center
        String[] headers = new String[]{"Customer name", "Room number", "Ski type", "Discount", "Duration (Days)"};
        model = new DefaultTableModel(headers, 0);
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        // TODO lépe:
        loadTable();

        // South
        JPanel buttonPanel = new JPanel();

        JButton formButton = new JButton("New rent");
        JButton detailButton = new JButton("Detail");
        JButton editButton = new JButton("Edit");
        JButton saveButton = new JButton("Save");

        formButton.addActionListener(e -> openForm());
        saveButton.addActionListener(e -> save());
        // TODO: dodělat zbytek tlačítek

        buttonPanel.add(formButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);

        add(title, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadTable(){
        rents.add(new Rent(
                "John",
                153,
                true,
                SkiType.SKI,
                4
        )); rents.add(new Rent(
                "John",
                153,
                true,
                SkiType.SKI,
                4
        )); rents.add(new Rent(
                "John",
                153,
                true,
                SkiType.SKI,
                4
        ));

        model.setRowCount(0);
        for(Rent rent : rents){
            model.addRow(rent.returnAsTableRow());
        }
    }

    private void save() {
        // TODO: uložit ArrayList rents
    }

    private void openForm() {
        // TODO: otevřít formulář, získat z něj Rent objekt a nacpat do ArrayListu
    }

    public static void main(String[] args) {
        new DashBoard().setVisible(true);
    }

}