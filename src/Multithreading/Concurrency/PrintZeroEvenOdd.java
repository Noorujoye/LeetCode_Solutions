package Multithreading.Concurrency;
public class PrintZeroEvenOdd {
    private int n;

    //by default value set to zero to start
    // 0 for zero turn
    // 1 for odd turn
    // 2 for even turn
    private int turn = 0;

    PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // wait notify only works if synchronized is there
    public synchronized void printZero() throws InterruptedException {
        for (int i=1; i<=n; i++) {
            // sleep the thread until my turn
            while (turn != 0) {
                wait();
            }
            System.out.print(0);
            turn = i % 2 == 0 ?  2 : 1;
            notifyAll();
            Thread.sleep(2000);
            // if my chance is not there,
            // I have to notify others to start the work,
            // but I don't whom exactly I have to wake up so,
            // I did notify all
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            while (turn != 1) {
                wait();
            }
            System.out.print(i);
            turn = 0;
            notifyAll();
            Thread.sleep(2000);
        }
    }

    public synchronized void printEven() throws InterruptedException{
        for (int i=2; i<=n; i+=2) {
            while (turn != 2) {
                wait();
            }
            System.out.print(i);
            turn = 0;
            notifyAll();
            Thread.sleep(2000);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        PrintZeroEvenOdd p = new PrintZeroEvenOdd(5);
        System.out.println(Thread.currentThread());
        Thread t1 = new Thread(() -> {
            try {
                p.printZero();

            } catch (InterruptedException e) {
                System.out.println("zero not printed...");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                p.printOdd();
            } catch (InterruptedException e) {
                System.out.println("odd not printed...");
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                p.printEven();
            } catch (InterruptedException e) {
                System.out.println("even not printed...");
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}

/*
Thread t1 = new Thread(() -> {
    p.printZero();
});
Worker t1 executes task printZero()
using shared object p

PrintZeroEvenOdd p = new PrintZeroEvenOdd(5);
Object p:
    n = 5
    turn = 0

    only one copy exists

Thread t1
Thread t2
Thread t3

All points to same object

          Object p
      ----------------
      n = 5
      turn = 0
      ----------------
         ^    ^    ^
         |    |    |
        t1   t2   t3

        this is shared object

        why we need synchronization???

        all threads modify same variable
        turn

        t1 -> turn = 0;
        t2 -> turn = 0;
        t3 -> turn = 0;

        All modfy same data

        race condition possible

        so synchronized is needed



 */

/*
23. One FINAL super important thing

This line:

Thread t1 = new Thread(() -> {
    p.printZero();
});

means:

Thread t1 starts execution
Then inside its execution,
it calls method on shared object p

Thread ≠ Object.
 */







/*
class PrintZeroEvenOdd {

    public static void main(String[] args) {

        for (int i=1; i<=5; i++) {
            System.out.print(0);
            System.out.print(i);
        }
    }
}
 */