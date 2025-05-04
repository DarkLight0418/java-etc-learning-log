package Chapter12_CollectionFW.collection.arraylist;

import java.util.ArrayList;

class MyQueue {
    private ArrayList<String> arrayQueue = new ArrayList<String>();

    public void enQueue(String data) {  // 큐의 맨 뒤에 요소 추가
        arrayQueue.add(data);
    }

    public String deQueue() {  // 큐의 맨 앞에서 요소를 꺼냄
        int len = arrayQueue.size();
        if (len == 0) {
            System.out.println("큐가 비었습니다.");
            return null;
        }

        return(arrayQueue.remove(0));  // 맨 앞의 자료를 변환하고 배열에서 제거
    }
}

public class QueueTest {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
