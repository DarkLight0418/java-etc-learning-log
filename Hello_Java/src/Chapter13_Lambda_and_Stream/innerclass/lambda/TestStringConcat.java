package Chapter13_Lambda_and_Stream.innerclass.lambda;

public class TestStringConcat {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";

        StringConcatImpl concat1 = new StringConcatImpl();
        concat1.makeString(s1, s2);
    }
}

// 클래스에서 인터페이스 구현
