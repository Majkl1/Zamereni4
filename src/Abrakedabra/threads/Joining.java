package Abrakedabra.threads;

public class Joining {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("začíná main vlákno");

        Thread first = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000+(int)(Math.random()*3000));
            } catch (InterruptedException e) {
                System.out.println("Albert byl zabit. :(");
            }

            System.out.println(Thread.currentThread().getName() + " is done");

        });

        first.setName("Albert");

        Thread second = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000+(int)(Math.random()*3000));
            } catch (InterruptedException e) {
                System.out.println("Albert byl zabit. :(");
            }

            System.out.println(Thread.currentThread().getName() + " is done");

        });

        second.setName("Patrik");

        first.start();
        second.start();

        System.out.println("main is done");

        System.out.println(first.getName() + ": " + first.getState());
        System.out.println(second.getName() + ": " + second.getState());
        first.interrupt();
        System.out.println(second.getName() + ": " + second.getState());

        first.join();
        System.out.println(first.getName() + ": " + first.getState());

        second.join();
        System.out.println(second.getName() + ": " + second.getState());

        System.out.println("Happy ending");

    }
}
