package Chapter10_Interface.No4_application_interface;

public class BookShelfTest {
    public static void main(String[] args) {
        Queue shelfQueue = new BookShelf();
        shelfQueue.enQueue("태백산맥 1");
        shelfQueue.enQueue("태백산맥 2");
        shelfQueue.enQueue("태백산맥 3");
        // 순서대로 요소 추가

        System.out.println(shelfQueue.deQueue());
        System.out.println(shelfQueue.deQueue());
        System.out.println(shelfQueue.deQueue());
        // 입력 순서대로 요소를 꺼내서 출력
    }
}
