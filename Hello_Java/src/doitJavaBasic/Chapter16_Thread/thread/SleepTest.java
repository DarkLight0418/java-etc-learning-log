package Chapter16_Thread.thread;

public class SleepTest extends Thread {
    public void run() {
        for (int i=0; i<10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {
        SleepTest test = new SleepTest();
        test.start();
    }
}