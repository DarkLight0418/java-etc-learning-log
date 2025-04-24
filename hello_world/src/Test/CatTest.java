package Test;

public class CatTest {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Didi";  // 개별 객체 공유
        cat1.age = 1;
        Cat.breed = "khj"; // 클래스 전체 공유

        cat1.printInfo();
    }
}
