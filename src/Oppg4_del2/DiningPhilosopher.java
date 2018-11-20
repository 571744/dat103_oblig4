package Oppg4_del2;

import java.util.Random;
import java.util.concurrent.Semaphore;
//import Oppg2_del1.Semaphore;


public class DiningPhilosopher {
    public static void main(String[] args) {
        Object[] chopsticks = new Object[5];

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

        Thread ph1 = new philosopher(chopsticks[0], chopsticks[1]);
        Thread ph2 = new philosopher(chopsticks[1], chopsticks[2]);
        Thread ph3 = new philosopher(chopsticks[2], chopsticks[3]);
        Thread ph4 = new philosopher(chopsticks[3], chopsticks[4]);
        Thread ph5 = new philosopher(chopsticks[4], chopsticks[0]);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
        ph5.start();
    }
}


class philosopher extends Thread {

    private final Object leftStick;
    private final Object rightStick;
    private static Semaphore sem;
    private static Semaphore test;

    public philosopher(Object l, Object r) {
        leftStick = l;
        rightStick = r;
        sem = new Semaphore(2);
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while (true) {
            try {
                sleep(rnd.nextInt(1000)); //Think

                sem.acquire();
                synchronized (leftStick) {
                    System.out.printf("%s plukket opp venstre %n", Thread.currentThread().getId());

                    sleep(rnd.nextInt(1000));
                    synchronized (rightStick) {
                        System.out.printf("%s spiser %n", Thread.currentThread().getId());

                        sleep(rnd.nextInt(1000)); //Eat
                    }
                }
                sem.release();

                System.out.printf("%s går tilbake til tenking %n", Thread.currentThread().getId());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}