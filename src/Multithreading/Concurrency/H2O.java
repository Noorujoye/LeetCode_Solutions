package Multithreading.Concurrency;

public class H2O {

    int hCount = 0 , oCount = 0;
    void print(char ch) {
        System.out.print(ch);
    }
    public void hydrogen () throws InterruptedException {
        synchronized (this) {
            while (hCount == 2) {
                wait();
            }
            print('H');
            hCount += 1;
            if (hCount == 2 && oCount == 1) {
                hCount = 0;
                oCount = 0;
            }
            notifyAll();
        }
    }
    public void oxygen() throws InterruptedException {
        synchronized (this) {
            while (oCount == 1) {
                wait();
            }
            print('O');
            oCount += 1;
            if (hCount == 2 && oCount == 1) {
                hCount = 0;
                oCount = 0;
            }
            notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        H2O h = new H2O();
        Thread t1 = new Thread(() -> {
                    try {
                        h.hydrogen();
                        h.hydrogen();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        Thread t2 = new Thread(() -> {
            try {
                h.oxygen();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();
        t1.start();
    }
}
