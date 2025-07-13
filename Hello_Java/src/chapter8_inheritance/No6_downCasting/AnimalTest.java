package Chapter8_inheritance.No6_downCasting;
import java.util.ArrayList;

// 상위 클래스 Animal 정의
class Animal {
    public void move() {  // 모든 Animal이 공통으로 가지는 move() 메서드
        System.out.println("동물이 움직입니다.");
    }
}

// Human 클래스: Animal 클래스를 상속받음
class Human extends Animal {
    @Override
    public void move() {  // move() 메서드 오버라이딩
        System.out.println("사람이 두 발로 걷습니다.");
    }

    public void readBook() {  // Human만이 가지는 기능
        System.out.println("사람이 책을 읽습니다.");
    }
}

// Tiger 클래스: Animal 클래스를 상속받음
class Tiger extends Animal {
    @Override
    public void move() {  // move() 메서드 오버라이딩
        System.out.println("호랑이가 네 발로 뜁니다.");
    }

    public void hunting() {  // Tiger만이 가지는 기능
        System.out.println("호랑이가 사냥을 합니다.");
    }
}

// Eagle 클래스: Animal 클래스를 상속받음
class Eagle extends Animal {
    @Override
    public void move() {  // move() 메서드 오버라이딩
        System.out.println("독수리가 하늘을 납니다.");
    }

    public void flying() {  // Eagle만이 가지는 기능
        System.out.println("독수리가 날개를 쭉 펴고 멀리 날아갑니다.");
    }
}

public class AnimalTest {
    // Animal 객체를 저장할 ArrayList 생성
    ArrayList<Animal> aniList = new ArrayList<>();

    public static void main(String[] args) {
        AnimalTest aTest = new AnimalTest(); // AnimalTest 객체 생성
        aTest.addAnimal(); // 리스트에 동물 객체 추가 및 move() 실행
        System.out.println("====== 원래 형으로 다운 캐스팅 ======");
        aTest.testCasting(); // 다운 캐스팅 테스트 실행
    }

    // 리스트에 여러 종류의 Animal 객체를 추가하는 메서드
    public void addAnimal() {
        aniList.add(new Human()); // Human 객체 추가
        aniList.add(new Tiger()); // Tiger 객체 추가
        aniList.add(new Eagle()); // Eagle 객체 추가

        // 각 객체의 move() 메서드 실행 (다형성 적용)
        for (Animal ani : aniList) {
            ani.move(); // 오버라이딩된 move() 실행됨
        }
    }

    // 다운 캐스팅을 테스트하는 메서드
    public void testCasting() {
        for (int i = 0; i < aniList.size(); i++) {    // 리스트의 모든 요소를 순차적으로 확인
            Animal ani = aniList.get(i);  // Animal 타입으로 객체 가져오기

            if (ani instanceof Human) {  // 객체가 Human 타입인지 확인
                Human h = (Human) ani;  // Human 타입으로 다운 캐스팅
                h.readBook();  // Human의 readBook() 메서드 실행
            }
            else if (ani instanceof Tiger) {  // 객체가 Tiger 타입인지 확인
                Tiger t = (Tiger) ani;  // Tiger 타입으로 다운 캐스팅
                t.hunting();  // Tiger의 hunting() 메서드 실행
            }
            else if (ani instanceof Eagle) {  // 객체가 Eagle 타입인지 확인
                Eagle e = (Eagle) ani;  // Eagle 타입으로 다운 캐스팅
                e.flying();  // Eagle의 flying() 메서드 실행
            }
            else {  // Animal 타입이지만 어느 하위 클래스에도 해당되지 않을 경우
                System.out.println("지원되지 않는 형입니다.");
            }
        }
    }
}
