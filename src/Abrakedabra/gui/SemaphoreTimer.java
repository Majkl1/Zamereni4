package Abrakedabra.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SemaphoreTimer extends JFrame {

    private JLabel red;
    private JLabel yellow;
    private JLabel green;

    private JButton start;
    private JButton stop;

    private JButton go;

    private int index = 2;

    private Timer t;

    public SemaphoreTimer() {
        setTitle("Semaphore Timer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        // Semaphore lights
        red = createLabel(Color.GRAY);
        yellow = createLabel(Color.GRAY);
        green = createLabel(Color.GRAY);

        // Go button
        go = new JButton("Go");
        go.setEnabled(false);

        // Start and Stop panel
        JPanel ssPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        start = new JButton("Start");
        stop = new JButton("Stop");

        // Bude se hodit pozdeji
        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);

        List<JLabel> semaphoreList = new ArrayList<>();
        semaphoreList.add(red);
        semaphoreList.add(yellow);
        semaphoreList.add(green);

        // TODO
        t = new Timer(1000, e ->{
            semaphoreList.forEach(label -> label.setBackground(Color.gray));

            index = (index + 1) % semaphoreList.size();

            semaphoreList.get(index).setBackground(colors.get(index));


        });

        t.setInitialDelay(0);


        start.addActionListener(e -> start());
        stop.addActionListener(e -> stop());
        go.addActionListener(e -> go());

        ssPanel.add(start);
        ssPanel.add(stop);

        // Add components to the window
        add(red);
        add(yellow);
        add(green);
        add(go);
        add(ssPanel);
    }

    private void start() {
        //TODO
        go.setEnabled(true);
        t.start();
    }

    private void stop() {
        //TODO
        go.setEnabled(false);
        t.stop();
    }

    private void go() {
        //TODO
        if (index == 0){
            JOptionPane.showMessageDialog(
                    this,
                    "You crossed on red!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "You crossed successfully",
                    "OK",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }

    private JLabel createLabel(Color color) {
        JLabel toReturn = new JLabel("");

        toReturn.setOpaque(true);
        toReturn.setBackground(color);

        return toReturn;
    }

    public static void main(String[] args) {
        new SemaphoreTimer().setVisible(true);
    }
}