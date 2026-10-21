package Abrakedabra.gui.rental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DashBoard extends JFrame {
    public static ArrayList<Rent> rents = new ArrayList<>();

    private JTable table;
    private static DefaultTableModel model;



    public DashBoard() {
        setTitle("Dashboard");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        rents.add(new Rent("Karel", 222, false, SkiType.SKI, 6));
        rents.add(new Rent("Pepa", 245, true, SkiType.SNOWBOARD, 9));

        //North
        JLabel title = new JLabel("Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Consolas", Font.BOLD, 18));


        //Centre
        String[] headers = new String[]{"Customer name", "Room number", "Ski type", "Discount", "Duration (Days)"};
        model = new DefaultTableModel(headers, 0);
        table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        reLoadTable();


        //South
        JPanel buttonPanel = new JPanel();

        JButton formButton = new JButton("Form");
        JButton detailButton = new JButton("Detail");
        JButton editButton = new JButton("Edit");
        JButton saveButton = new JButton("Save");
        JButton deleteButton = new JButton("Delete");

        formButton.addActionListener(e -> openForm());
        saveButton.addActionListener(e -> save());
        editButton.addActionListener(e -> edit(table.getSelectedRow()));
        deleteButton.addActionListener(e -> delete(table.getSelectedRow()));

        buttonPanel.add(formButton);
        buttonPanel.add(detailButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);

        add(title, BorderLayout.NORTH);
        add(pane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    static void reLoadTable(){
        model.setRowCount(0);
        for (Rent rent : rents){
            model.addRow(rent.returnAsTableRow());
        }
    }

    private void edit(int rowNumber){
        if (rowNumber < 0){
            JOptionPane.showMessageDialog(this, "Row isn´t selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Rent r = rents.get(rowNumber);
        RentalForm form = new RentalForm(r);
        form.setVisible(true);
    }

    private void delete(int rowNumber){
        rents.remove(rowNumber);
        reLoadTable();
    }

    private void save() {
    }

    private void openForm() {
        RentalForm form = new RentalForm();
        form.setVisible(true);
    }

    public static void main(String[] args) {
        new DashBoard().setVisible(true);
    }
}
