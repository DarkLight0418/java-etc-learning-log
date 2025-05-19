package Chapter11_JDKBasicClass.No5_Class;

// ClassTest 클래스: 클래스 정보를 얻는 세 가지 방법을 보여주는 예제
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 객체를 생성한 후 getClass() 메서드를 사용하여 클래스 정보 얻기
        Person person = new Person();               // Person 클래스의 인스턴스 생성
        Class pClass1 = person.getClass();          // Object 클래스의 getClass() 메서드를 사용
        System.out.println(pClass1.getName());      // 클래스의 전체 이름(패키지 포함)을 출력

        // 2. 클래스 이름에서 직접 클래스 객체 얻기 (컴파일 시점에 클래스가 존재함)
        Class pClass2 = Person.class;               // .class 리터럴을 사용하여 Class 객체를 직접 참조
        System.out.println(pClass2.getName());      // 클래스의 전체 이름 출력

        // 3. 문자열로 클래스 이름을 제공하여 동적으로 클래스 객체 로드
        // - Class.forName()은 런타임에 클래스 이름을 이용하여 해당 클래스를 로드
        // - 주의: 클래스의 패키지 이름까지 포함해야 함
        Class pClass3 = Class.forName("Chapter11_JDKBasicClass.No5_Class.Person");
        System.out.println(pClass3.getName());      // 클래스의 전체 이름 출력
    }
}
