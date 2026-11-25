package Abrakedabra.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreadsBasics {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("wait 3 seconds");
        Thread.sleep(3000);
        System.out.println("you waisted 3 seconds of your life");

        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread());

        FirstThread fred = new FirstThread();
        fred.setName("Prvni vlakno");
        fred.start();
        System.out.println("---------------------");
        System.out.println(Thread.activeCount());

        Runnable alfred = () -> {
            //nyní jsme v run()
            System.out.println(Thread.currentThread().getName());
            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(Thread.currentThread().getName() + ".txt")));
                for (int i = 0; i < 50000000; i++) {
                    pw.println(Thread.currentThread().getName() + ": " + i);
                }

                pw.close();
            } catch (IOException e) {
                System.out.println("Thread died :(");
            }
            System.out.println(Thread.currentThread().getName() + " is finished");
        };

        Thread ovladačAlfreda = new Thread(alfred);
        ovladačAlfreda.setName("Alfred");
        ovladačAlfreda.start();

        System.out.println("Happy end hlavního vlákna");

    }
}


class FirstThread extends Thread{
    @Override
    public void run() {
        System.out.println(getName());
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(getName() + ".txt")));
            for (int i = 0; i < 50000000; i++) {
                pw.println(getName() + ": " + i);
            }

            pw.close();
        } catch (IOException e) {
            System.out.println("Thread died :(");
        }
        System.out.println(getName() + " is finished");
    }
}