package temp_chapter2;

public class CharacterEx1 {
    public static void main(String[] args) {
        char ch1 = 'A';
        System.out.println(ch1); // 문자
        System.out.println((int)ch1);  // 아스키 코드 값

        char ch2 = 66;  // 정수값 대입
        System.out.println(ch2);  // 해당 정수값 문자 출력

        int ch3 = 67;
        System.out.println(ch3);  // 문자 정수값 출력
        System.out.println((char)ch3);  // 문자 출력
    }
}
