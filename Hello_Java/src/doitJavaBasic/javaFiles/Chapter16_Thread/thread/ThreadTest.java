package Chapter16_Thread.thread;

class MyThread extends Thread {
    public void run() {
        int i;  // 스레드가 실행될 때 수행할 코드를 run()에 구현
        for (i=0; i<=200; i++) {
            System.out.print(Thread.currentThread().getName() + ":" + i + "\t");
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        
        MyThread thread1 = new MyThread();   // 첫 번째 스레드를 생성
        thread1.start();  // start()를 호출하면 Thread 클래스의 run()이 수행됨
        
        MyThread thread2 = new MyThread();   // 두 번째 스러드를 생성
        thread2.start();

        System.out.println("end");  // 스레드가 끝나면 end를 출력
    }
}