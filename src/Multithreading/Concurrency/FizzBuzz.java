package Multithreading.Concurrency;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    private int n;
    // shared resources
    private int current = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }
    List<String> list = new ArrayList<>();
    public void print(String msg) {
        list.add(msg);
    }
    public synchronized void fizz() throws InterruptedException {
        while (current <= n) {
            if ((current % 3 != 0) || (current % 5 == 0)) {
                wait();
                continue;
            }
            print("Fizz");
            current += 1;
            notifyAll();
        }
    }
    public synchronized void Buzz() throws InterruptedException {
        while (current <= n) {
            if ((current % 5 != 0) || (current % 3 == 0)) {
                wait();
                continue;
            }
            print("Buzz");
            current += 1;
            notifyAll();
        }
    }
    public synchronized void fizzBuzz() throws InterruptedException {
        while (current <= n) {
            if ((current % 5 != 0) || (current % 3 != 0)) {
                wait();
                continue;
            }
            print("FizzBuzz");
            current += 1;
            notifyAll();
        }
    }
    public synchronized void number() throws InterruptedException {
        while (current <= n) {
            if ((current % 3 == 0) || (current % 5 == 0)) {
                wait();
                continue;
            }
            print(""+current);
            current += 1;
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz f = new FizzBuzz(15);
        Thread a = new Thread(() -> {
            try {
                f.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b = new Thread(() -> {
            try {
                f.Buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread c = new Thread(() -> {
            try {
                f.fizzBuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread d= new Thread(() -> {
            try {
                f.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        b.start();
        c.start();
        d.start();
        a.join();
        b.join();
        c.join();
        d.join();

        System.out.println(f.list);
    }
}
