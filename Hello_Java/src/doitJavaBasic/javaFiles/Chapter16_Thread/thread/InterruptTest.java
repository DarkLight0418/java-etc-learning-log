package Chapter16_Thread.thread;

public class InterruptTest extends Thread {
    public void run() {
        try {
            int i;
            
            for(i = 0; i < 10; i++) {
                Thread.sleep(3000);
                System.out.print(i + "\t");
            }  // 3초동안 잠들었다가 정수 한 개 출력
            
        } catch (InterruptedException e) {
            System.out.println("wake up");
        } // InterruptException이 발생하면 'wake up'을 출력
        System.out.println("end");
    }
    public static void main(String[] args) throws InterruptedException {
        InterruptTest test = new InterruptTest();
        
        test.start();
        Thread.sleep(3000);
        test.interrupt();
        
        // 스레드를 시작하고 3초 후에 interrupt() 메소드 호출
    }
}
