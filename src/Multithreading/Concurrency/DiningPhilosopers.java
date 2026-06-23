package Multithreading.Concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopers {

    private final ReentrantLock[] forks;

    public DiningPhilosopers() {

        forks = new ReentrantLock[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeft,
            Runnable pickRight,
            Runnable eat,
            Runnable putLeft,
            Runnable putRight
    ) {

        int left = philosopher;
        int right = (philosopher + 1) % 5;

        ReentrantLock first;
        ReentrantLock second;

        boolean leftFirst;

        if (philosopher % 2 == 0) {

            first = forks[left];
            second = forks[right];

            leftFirst = true;

        } else {

            first = forks[right];
            second = forks[left];

            leftFirst = false;
        }

        first.lock();
        second.lock();

        try {

            if (leftFirst) {
                pickLeft.run();
                pickRight.run();
            } else {
                pickRight.run();
                pickLeft.run();
            }

            eat.run();

            if (leftFirst) {
                putRight.run();
                putLeft.run();
            } else {
                putLeft.run();
                putRight.run();
            }

        } finally {

            second.unlock();
            first.unlock();
        }
    }

    static void main(String[] args) {
        DiningPhilosopers dp = new DiningPhilosopers();

        for (int i = 0; i < 5; i++) {

            int philosopher = i;

            new Thread(() -> {

                dp.wantsToEat(

                        philosopher,

                        () -> System.out.println(philosopher + " picked LEFT"),

                        () -> System.out.println(philosopher + " picked RIGHT"),

                        () -> System.out.println(philosopher + " is EATING"),

                        () -> System.out.println(philosopher + " put LEFT"),

                        () -> System.out.println(philosopher + " put RIGHT")
                );

            }).start();
        }
    }
}