package Test;

public class Cat {
    // 전역 변수
    String name;
    int age;
    static String breed; // 클래스 변수

    public void printInfo() {
        // 지역 변수
        String message = "My cat's name is " + name + ", She is " + age + " years old, and he is a " + breed;
        System.out.println(message);
    }
}
