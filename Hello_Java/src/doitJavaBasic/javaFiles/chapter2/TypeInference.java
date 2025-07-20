package temp_chapter2;

public class TypeInference {
    public static void main(String[] args) {
        var i = 10;  // int i
        var j = 10.0;  // double j
        var str = "hello";  // String str = "hello"

        System.out.println(i);
        System.out.println(j);
        System.out.println(str);

        str = "test";
        // str = 3;

        System.out.println(str);
    }
}
