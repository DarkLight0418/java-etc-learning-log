package Chapter11_JDKBasicClass.No2_String;

public class StringBuilderTest {
    public static void main(String[] args) {
        // String 객체 생성 (불변 객체)
        String javaStr = new String("Java");
        System.out.println("javaStr 문자열 주소: " + System.identityHashCode(javaStr));
        // identityHashCode: 실제 메모리 주소에 가까운 고유값 출력

        // StringBuilder 생성 (가변 객체), javaStr의 문자열을 복사해서 사용
        StringBuilder buffer = new StringBuilder(javaStr);
        System.out.println("연산 전 buffer 메모리 주소: " + System.identityHashCode(buffer));

        // 문자열 추가 (append): 기존 buffer 내용에 문자열을 연결함
        buffer.append(" and");
        buffer.append(" android");
        buffer.append(" programming is fun!!!");
        System.out.println("연산 후 buffer 메모리 주소: " + System.identityHashCode(buffer));
        // 메모리 주소가 바뀌지 않음 => 같은 객체를 계속 수정 중

        // buffer의 내용을 String으로 변환 (다시 불변 객체 생성)
        javaStr = buffer.toString();
        System.out.println(javaStr);
        System.out.println("새로 만들어진 javaStr 문자열 주소: " + System.identityHashCode(javaStr));
    }
}
