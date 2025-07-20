package Chapter13_Lambda_and_Stream.innerclass.stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

// BinaryOperator 인터페이스를 구현한 클래스
// 두 문자열을 비교하여 바이트 길이가 더 긴 문자열을 반환
class CompareString implements BinaryOperator<String> {
    @Override
    public String apply(String s1, String s2) {
        // 문자열의 바이트 길이 비교
        if (s1.getBytes().length >= s2.getBytes().length)
            return s1;  // s1이 더 길면 s1 반환
        else
            return s2;  // s2가 더 길면 s2 반환
    }
}

public class ReduceTest {
    public static void main(String[] args) {
        // 문자열 배열 선언
        String[] greetings = {"안녕하세요~~", "hello", "Good morning", "반갑습니다 :)"};

        // reduce()를 람다 표현식으로 사용
        // 첫 번째 인수는 초기값 ""
        // 두 번째 인수는 두 문자열을 비교해서 더 긴 쪽을 반환하는 람다식
        System.out.println(
                Arrays.stream(greetings)  // 스트림 생성
                        .reduce("", (s1, s2) -> {  // 초기값 ""부터 비교 시작
                            if (s1.getBytes().length >= s2.getBytes().length)
                                return s1;
                            else
                                return s2;
                        })
        );

        // BinaryOperator 구현체를 사용한 reduce()
        // Optional<String>을 반환하므로 get()으로 꺼냄
        String str = Arrays.stream(greetings)
                .reduce(new CompareString())  // CompareString 클래스 사용
                .get();  // Optional에서 값 꺼내기

        System.out.println(str);  // 가장 긴 문자열 출력
    }
}
