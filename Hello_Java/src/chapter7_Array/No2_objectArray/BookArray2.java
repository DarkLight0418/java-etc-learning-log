package chapter7_Array.No2_objectArray;

public class BookArray2 {
    public static void main(String[] args) {
        Book[] library = new Book[5];;

        library[0] = new Book("자바 프로그래밍", "Kim");
        library[1] = new Book("데미안", "헤르만 헤세");
        library[2] = new Book("어떻게 살 것인가", "유시민");
        library[3] = new Book("토지", "박경리");
        library[4] = new Book("어린 왕자", "생택쥐페리");  // 인스턴스 생성 후 배열에 저장

        for (int i = 0; i < library.length; i++) {  // Book 인스턴스
            library[i].showBookInfo();
        }
        for (int i = 0; i < library.length; i++) {  // Book 인스턴스를 저장한 메모리 공간 주소
            System.out.println(library[i]);
        }
    }
}
