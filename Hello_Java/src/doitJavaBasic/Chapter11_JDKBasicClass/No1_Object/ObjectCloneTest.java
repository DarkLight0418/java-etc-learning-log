package Chapter11_JDKBasicClass.No1_Object;

// 좌표를 나타내는 Point 클래스 정의
class Point {
    int x; // x좌표
    int y; // y좌표

    // 생성자: x, y 좌표를 받아 초기화
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 객체 정보를 문자열로 반환 (toString() 오버라이딩)
    public String toString() {
        return "x = " + x + "," + "y = " + y;
    }
}

// 원(Circle)을 표현하는 클래스. 복제를 위해 Cloneable 인터페이스 구현
class Circle implements Cloneable {
    Point point; // 원의 중심 좌표
    int radius;  // 반지름

    // 생성자: 중심 좌표(x, y)와 반지름(radius)을 받아 초기화
    Circle(int x, int y, int radius) {
        this.radius = radius;
        point = new Point(x, y); // 중심 좌표를 Point 객체로 생성
    }

    // 객체 정보를 문자열로 반환 (toString() 오버라이딩)
    public String toString() {
        return "원점은 " + point + "이고, " + "반지름은 " + radius +  "입니다.";
    }

    // clone() 메서드 오버라이딩: Object 클래스의 clone() 사용
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // 기본적인 얕은 복사 수행
        // 주의: Point 객체는 깊은 복사가 되지 않음 (같은 참조를 공유)
    }
}

public class ObjectCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 새로운 Circle 객체 생성
        Circle circle = new Circle(10, 20, 30);

        // circle 객체를 복제 (얕은 복사): 객체 자체는 새로 만들어지지만 내부 Point 객체는 동일 참조
        Circle copuCircle = (Circle)circle.clone();

        // 원본 객체 출력
        System.out.println(circle);

        // 복제된 객체 출력
        System.out.println(copuCircle);

        // 원본 객체의 실제 메모리 주소(해시 코드) 출력
        System.out.println(System.identityHashCode(circle));

        // 복제된 객체의 실제 메모리 주소 출력 (다르므로 별도의 객체임을 알 수 있음)
        System.out.println(System.identityHashCode(copuCircle));
    }
}
