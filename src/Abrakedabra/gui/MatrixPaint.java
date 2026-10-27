package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;

public class MatrixPaint extends JFrame {
    private JPanel matrix;
    private JLabel[][] labels;
    private final int DIMENSION = 20;
    JButton paintButton;

    public MatrixPaint(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        paintButton = new JButton("Paint");
        matrix = new JPanel(new GridLayout(DIMENSION, DIMENSION, 5, 5));
        labels = new JLabel[DIMENSION][DIMENSION];

        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setOpaque(true);
                matrix.add(labels[i][j]);
            }
        }
        paintButton.addActionListener(e -> redrawOnion());

        add(paintButton, BorderLayout.NORTH);
        add(matrix, BorderLayout.CENTER);
    }

    private void redrawOnion(){
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);
            boolean isJmax = false;
            boolean isImax = false;


            for (int i = 0; i < DIMENSION; i++) {

                if (!isImax && !isJmax){
                    for (int j = 0; j < DIMENSION; j++) {
                        Thread.sleep(16);
                        labels[i][j].setBackground(Color.blue);
                        matrix.paintImmediately(0, 0, getWidth(), getHeight());
                        if (j == DIMENSION - 1) {
                            isJmax = true;
                        }
                    }
                }
                if (!isImax && isJmax){
                    i = DIMENSION-1;
                    for (int j = 0; j < DIMENSION; j++) {
                        Thread.sleep(16);
                        labels[j][i].setBackground(Color.blue);
                        matrix.paintImmediately(0, 0, getWidth(), getHeight());
                    }
                    isImax = true;
                }
                if (isImax && isJmax){
                    for (int j = DIMENSION-1; j >= 0; j--) {
                        Thread.sleep(16);
                        labels[i][j].setBackground(Color.blue);
                        matrix.paintImmediately(0, 0, getWidth(), getHeight());
                        if (j == 1) {
                            isJmax = false;
                        }
                    }
                }
                if (isImax && !isJmax){
                    for (int j = DIMENSION-1; j >= 0; j--) {
                        Thread.sleep(16);
                        labels[j][i].setBackground(Color.blue);
                        matrix.paintImmediately(0, 0, getWidth(), getHeight());
                        if (j == 1) {
                            isImax = false;
                        }
                    }
                }


            }
            paintButton.setText("Finnished drawing");



        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void redrawCollumn(){
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);


            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    Thread.sleep(16);
                    labels[j][i].setBackground(Color.blue);
                    matrix.paintImmediately(0,0, getWidth(), getHeight());
                }
            }
            paintButton.setText("Finnished drawing");



        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reDrawBack(){
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);


            for (int i = DIMENSION-1; i >= 0; i--) {
                for (int j = DIMENSION-1; j >= 0; j--) {
                    Thread.sleep(16);
                    labels[i][j].setBackground(Color.blue);
                    matrix.paintImmediately(0,0, getWidth(), getHeight());
                }
            }
            paintButton.setText("Finnished drawing");



        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private void redraw() {
        try {
            paintButton.setText("Drawing...");
            paintButton.setEnabled(false);


            for (int i = 0; i < DIMENSION; i++) {
                for (int j = 0; j < DIMENSION; j++) {
                    Thread.sleep(16);
                    labels[i][j].setBackground(Color.blue);
                    matrix.paintImmediately(0,0, getWidth(), getHeight());
                }
            }
            paintButton.setText("Finnished drawing");



        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        new MatrixPaint().setVisible(true);
    }
}
