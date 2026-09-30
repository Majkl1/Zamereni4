package Abrakedabra.gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableDemo extends JFrame {
    public TableDemo(){
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = new String[]{"Col 1", "Col 2", "Col 3", "Col 4", "Col 5"};


        DefaultTableModel model = new DefaultTableModel(columns, 0);
        model.addRow(new String[]{"I", "II", "III", "IV", "V"});
        model.addRow(new String[]{"A", "B", "C", "D", "E"});
        model.addRow(new String[]{"A", "B"});


        model.removeRow(1); //odstraní řádek

        model.setRowCount(0); //vycistí celou tabulku


        for (int i = 0; i < 100; i++) {
            model.addRow(new String[]{"I", "II", "III", "IV", "V"});
        }


        JTable table = new JTable(model);
        table.setFont(new Font("MV Boli", Font.BOLD, 16));
//        table.setForeground(Color.RED);
//        table.setBackground(Color.blue);
//        table.setSelectionBackground(Color.CYAN);
//        table.setEnabled(false);
//        table.setGridColor(Color.red);
        table.setRowHeight(34);
        table.setRowMargin(16);



        JScrollPane scrollPane = new JScrollPane(table);


        add(scrollPane);

        pack();
    }


    public static void main(String[] args) {
        new TableDemo().setVisible(true);
    }
}
