package temp_chapter2;

public class Constant {
    public static void main(String[] args) {
        final int MAX_NUM = 100;
        final int MIN_NUM;

        MIN_NUM = 0;

        System.out.println(MAX_NUM);
        System.out.println(MIN_NUM);

        // MAX_NUM = 1000; - final(자바 상수 선언)으로 인해 이 코드 실행 시 오류 발생
    }
}
