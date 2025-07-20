package doitJavaBasic.chapter5_class1;

public class PersonTest {
    public static void main(String[] args) {
        Person1 personLee = new Person1();  // 디폴트 생성자로 클래스를 생성한 후 인스턴스 변숫값을 따로 초기화
        personLee.name = "이진호";
        personLee.weight = 85.5F;
        personLee.height = 180.0F;

        Person1 personKim = new Person1("우정아", 170, 61);
        // 인스턴스 변수를 초기화하는 동시에 클래스 생성
    }
}
