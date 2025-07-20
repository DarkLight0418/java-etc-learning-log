package Chapter13_Lambda_and_Stream.innerclass.lambda;

public class StringConcatImpl implements StringConcat {
    @Override
    public void makeString(String s1, String s2) {
        System.out.println( s1 + "," + s2);
    }
}
