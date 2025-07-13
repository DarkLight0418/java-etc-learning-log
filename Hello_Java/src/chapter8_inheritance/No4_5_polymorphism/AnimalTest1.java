// 패키지 선언: 해당 클래스들이 속한 패키지 이름을 명시
package Chapter8_inheritance.No4_5_polymorphism;

// 부모 클래스(슈퍼 클래스) Animal 선언
class Animal {
    // move() 메서드 정의: 모든 동물이 공통적으로 가지고 있는 움직임 기능
    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}

// Animal 클래스를 상속받은 Human(사람) 클래스 정의
class Human extends Animal {
    // move() 메서드를 오버라이딩하여 사람의 이동 방식 구현
    @Override
    public void move() {
        System.out.println("사람이 두 발로 걷습니다.");
    }
}

// Animal 클래스를 상속받은 Tiger(호랑이) 클래스 정의
class Tiger extends Animal {
    // move() 메서드를 오버라이딩하여 호랑이의 이동 방식 구현
    public void move() {
        System.out.println("호랑이가 네 발로 뜁니다.");
    }
}

// Animal 클래스를 상속받은 Eagle(독수리) 클래스 정의
class Eagle extends Animal {
    // move() 메서드를 오버라이딩하여 독수리의 이동 방식 구현
    public void move() {
        System.out.println("독수리가 하늘을 납니다.");
    }
}

// 실행을 담당하는 AnimalTest1 클래스 (main 메서드 포함)
public class AnimalTest1 {
    public static void main(String[] args) {
        // AnimalTest1 객체 생성
        AnimalTest1 aTest = new AnimalTest1();

        // moveAnimal() 메서드를 호출하여 각각의 동물 객체의 move() 실행
        aTest.moveAnimal(new Human()); // 사람 객체 전달 -> 오버라이딩된 move() 실행
        aTest.moveAnimal(new Tiger()); // 호랑이 객체 전달 -> 오버라이딩된 move() 실행
        aTest.moveAnimal(new Eagle()); // 독수리 객체 전달 -> 오버라이딩된 move() 실행
    }

    // 다형성을 활용한 moveAnimal() 메서드 정의
    // 매개변수 타입이 Animal이므로 Animal을 상속받은 모든 객체를 받을 수 있음
    public void moveAnimal(Animal animal) {
        // 실제 전달된 객체의 move() 메서드 실행 (오버라이딩된 메서드가 호출됨)
        animal.move();
    }
}
