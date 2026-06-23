package Multithreading.Concurrency;

class Foo {

    public enum Turn {
        FIRST , SECOND , THIRD
    }
    Turn turn = Turn.FIRST;

    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        while (turn != Turn.FIRST ) {
            wait();
        }
        printFirst.run();
        turn = Turn.SECOND;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while (turn != Turn.SECOND) {
            wait();
        }
        printSecond.run();
        turn = Turn.THIRD;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while (turn != Turn.THIRD) {
            wait();
        }
        printThird.run();
        notifyAll();
    }

    public static void main(String[] args) {
        Foo f = new Foo();

        Runnable printFirst = () -> {
            System.out.print("first");
        };
        Runnable printSecond = () -> {
            System.out.print("second");
        };
        Runnable printThird = () -> {
            System.out.print("third");
        };

        Thread a = new Thread( () -> {
            try {
                f.first(printFirst);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}