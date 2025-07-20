package Chapter13_Lambda_and_Stream.innerclass.lambda;

public class TestMyNumber {
    public static void main(String[] args) {
        MyNumber max = (x, y) -> (x >= y) ? x : y;  // 람다식을 인터페이스형 변수 max에 대입
        System.out.println(max.getMax(10, 20));  // 인터페이스형 변수로 메서드 호출
    }
}
