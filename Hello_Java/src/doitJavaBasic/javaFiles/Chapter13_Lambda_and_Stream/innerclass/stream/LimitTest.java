package Chapter13_Lambda_and_Stream.innerclass.stream;

import java.util.Arrays;
import java.util.List;

public class LimitTest {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("파인애플", "사과", "바나나", "귤");

        System.out.print("기본 정렬 (오름차순으로 정렬): ");

        // 오름차순으로 정렬
        fruits.stream()
                .sorted().limit(2)
                .forEach(s -> System.out.print(s + " "));
    /* 과일 이름을 오름차순으로 정렬한 결과에 limit() 연산ㅇ을 추가해 과일 2개를 출력 */

        System.out.println();

        System.out.print("맞춤형 정렬 (문자열 길이에 따라 정렬): ");
        // 문자열 길이에 따라 정렬
        fruits.stream()
                .sorted((f1, f2) -> Integer.compare(f1.length(), f2.length())).limit(2)
                .forEach(s -> System.out.print(s + " "));
        /* 과일 이름의 길이에 따라 정렬한 결과에 limit() 연산을 추가해 과일 2개를 출력 */
    }
}
