package Multithreading.Concurrency;

import java.util.Scanner;

class FooBar {
    private int n;
    int turn = 1;

    public FooBar(int n) {
        this.n = n;
    }
    public synchronized void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (turn != 1) {
                wait();
            }
            System.out.print("foo");
            turn = 2;
            notify();
        }
    }
    public synchronized void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (turn != 2) {
                wait();
            }
            System.out.print("bar");
            System.out.println();
            turn = 1;
            notify();
        }
    }

    public static void main(String[] args) {
        System.out.print("enter n : ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        FooBar f = new FooBar(n);

        Thread a = new Thread( () -> {
            try {
                f.foo();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b = new Thread( () -> {
            try {
                f.bar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        b.start();
    }
}