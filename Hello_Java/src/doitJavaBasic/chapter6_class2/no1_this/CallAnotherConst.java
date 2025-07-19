package chapter6_class2.no1_this;

class Person {
    String name;
    int age;

    Person() {
        this("이름 없음", 1);  // Person(String, int) 생성자 호출
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person returnItSelf() {
        return this;
    }
}

public class CallAnotherConst {
    public static void main(String[] args) {
        Person noName = new Person();
        System.out.println(noName.name);
        System.out.println(noName.age);

        Person p = noName.returnItSelf( );  // this 값을 참조 변수에 대입
        System.out.println(p);  // noName.returnItSelf()의 반환값 출력
        System.out.println(noName);  // 참조 변수 출력
    }
}
