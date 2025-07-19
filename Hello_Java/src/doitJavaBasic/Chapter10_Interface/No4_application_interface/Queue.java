package Chapter10_Interface.No4_application_interface;

public interface Queue {
    void enQueue(String title);  // 배열의 맨 마지막에 추가
    String deQueue(); // 배열의 맨 처음 항목 반환
    int getSize();  // 현재 Queue에 있는 요소 개수 반환
}
