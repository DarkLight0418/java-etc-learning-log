package chapter7_Array.No3_ArrayListClass;
import chapter7_Array.No2_objectArray.Book;
import java.util.ArrayList;  // ArrayList 클래스 임포트

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<Book>();  // ArrayList 선언

        library.add(new Book("태백산맥", "조정래"));
        library.add(new Book("데미안", "헤르만 헤세"));
        library.add(new Book("어떻게 살 것인가", "유시민"));
        library.add(new Book("토지", "박경리"));
        library.add(new Book("어린 왕자", "생택쥐페리"));  // add() 메서드로 요솟값 추가

        for (int i = 0; i < library.size(); i++) {
            Book book = library.get(i);
            book.showBookInfo();
        }
        System.out.println();  // 행 출력이 끝난 후 한 줄 띄움

        System.out.println("=== 향상된 for문 사용 ===");
        for (Book book : library) {
            book.showBookInfo();
        }
    }
}
