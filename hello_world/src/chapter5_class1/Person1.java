package chapter5_class1;

public class Person1 {
    String name;
    float height;
    float weight;
    
    public Person1() { }  // 자바가 컴파일러 디폴트 생성자를 자동으로 제공
        // 이 경우 직접 생성자를 직접 구현하여 PersonTest.java 파일의 오류를 막기 위해 디폴트 생성자 직접 서술
    public Person1(String pname) {
        name = pname;    // 사람 이름을 매개변수로 입력받아서 Person 클래스를 생성하는 생성자를 구현
    }
}


