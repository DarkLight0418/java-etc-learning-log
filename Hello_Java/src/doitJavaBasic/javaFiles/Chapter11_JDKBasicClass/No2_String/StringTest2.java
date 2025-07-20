package Chapter11_JDKBasicClass.No2_String;

public class StringTest2 {
    public static void main(String[] args) {
        String javaStr = new String("java");
        String androidStr = new String("android");
        System.out.println(javaStr);
        System.out.println("처음 문자열 주솟값: " + System.identityHashCode(javaStr));

        javaStr = javaStr.concat(androidStr);  // javaStr과 androidStr을 연결하여 javaStr에 대입

        System.out.println(javaStr);
        System.out.println("연결된 문자열 주솟값: " + System.identityHashCode(javaStr));
    }
}
