package Chapter11_JDKBasicClass.No1_Object;

class Book {
    int bookNumber;
    String bookTitle;

    Book(int bookNumber, String bookTitle) {
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
    }
    
    @Override
    public String toString() {
        return bookTitle + "," + bookNumber;  // object 클래스의 toString() 메서드 재정의
    }
}

public class ToStringEx {
    public static void main(String[] args) {
        Book book1 = new Book(200, "장미");

        System.out.println(book1);  // 인스턴스 정보(클래스 이름, 주솟값)를 출력
        System.out.println(book1.toString());  // toString() 메서드로 인스턴스 정보(클래스 이름, 주솟값)를 출력
    }
}
