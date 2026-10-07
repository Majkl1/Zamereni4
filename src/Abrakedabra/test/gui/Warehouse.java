package Abrakedabra.test.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

public class Warehouse extends JFrame {

    ArrayList<Product> data;
    DefaultTableModel model;

    JRadioButton allButton;
    JRadioButton lowStockButton;
    JRadioButton inStockButton;

    JTextField limitField;

    JLabel productsNumber;
    JLabel totalValue;


    Warehouse() {

        setTitle("Warehouse");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setSize(500, 1000);

        JPanel northPanel = new JPanel(new BorderLayout());

        JPanel up = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel down = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel show = new JLabel("Show:");

        ButtonGroup group = new ButtonGroup();
        allButton = new JRadioButton("All");
        lowStockButton = new JRadioButton("Low stock");
        inStockButton = new JRadioButton("In stock");

        group.add(allButton);
        group.add(lowStockButton);
        group.add(inStockButton);

        allButton.setSelected(true);

        up.add(show);
        up.add(allButton);
        up.add(lowStockButton);
        up.add(inStockButton);



        JLabel filterLabel = new JLabel("Low stock below:");

        JButton apply = new JButton("Apply");

        limitField = new JTextField();
        limitField.setPreferredSize(new Dimension(50, 20));


        apply.addActionListener(e ->{
            apply();
        });


        down.add(filterLabel);
        down.add(limitField);
        down.add(apply);

        northPanel.add(up, BorderLayout.NORTH);
        northPanel.add(down, BorderLayout.SOUTH);



        String[] columnsName = {"Product", "Category", "Pieces", "price", "Value"};
        model = new DefaultTableModel(columnsName, 0);
        JTable table = new JTable(model);

        loadData("data/Products.txt");
        fillTable(data);


        JScrollPane scrollPane = new JScrollPane(table);

        JPanel southPanel = new JPanel();

        productsNumber = new JLabel();
        totalValue = new JLabel();


        southPanel.add(productsNumber);
        southPanel.add(totalValue);

        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        pack();
    }

    void apply(){
        int lowStock = Integer.parseInt(limitField.getText());
        ArrayList<Product> products = new ArrayList<>();

        if (allButton.isSelected()){
            products = new ArrayList<>(data);
        }
        if (lowStockButton.isSelected()){
            products = new ArrayList<>(data.stream()
                    .filter(p -> p.getPieces() < lowStock)
                    .toList() );

        }
        if (inStockButton.isSelected()){
            products = new ArrayList<>(data.stream()
                    .filter(p -> p.getPieces() > lowStock)
                    .toList() );
        }

        model.setRowCount(0);
        fillTable(products);

        int allProducts = products.size();
        double cost = products.stream()
                .mapToDouble(Product::getValue)
                .sum();

        productsNumber.setText("Products: " + allProducts);

        totalValue.setText("Total value: " + cost + " CZK");

    }


    void loadData(String filePath) {
        try {
            data = new ArrayList<>(
                    Files.lines(Path.of(filePath))
                            .map(line -> line.split(";"))
                            .map(parts -> new Product(
                                parts[0],
                                parts[1],
                                Integer.parseInt(parts[2]),
                                Double.parseDouble(parts[3])
                            )).toList()
            );
        } catch (IOException e) {
            System.out.println("Chyba při načítání souborů: " + e);
        }
    }


    void fillTable(ArrayList<Product> products) {
        for (Product product : products){
            model.addRow(product.getAsTableRow());
        }
    }



    public static void main(String[] args) {

        Warehouse window = new Warehouse();
        window.setVisible(true);
    }
}


class Product {

    String name;
    String category;

    int pieces;

    double price;


    public Product(String name,
                   String category,
                   int pieces,
                   double price) {

        this.name = name;
        this.category = category;
        this.pieces = pieces;
        this.price = price;
    }


    public int getPieces() {
        return pieces;
    }


    public double getValue() {
        return price * pieces;
    }


    public String[] getAsTableRow() {

        return new String[]{
                name,
                category,
                String.valueOf(pieces),
                String.format("%.2f", price),
                String.format("%.2f", getValue())
        };
    }
}