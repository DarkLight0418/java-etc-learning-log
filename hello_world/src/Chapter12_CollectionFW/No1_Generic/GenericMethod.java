package Chapter12_CollectionFW.No1_Generic;

// 제네릭 메서드를 가지는 클래스
public class GenericMethod {

    // 제네릭 메서드 선언: T, V는 타입 매개변수
    public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) {
        // p1의 x좌표를 Number로 변환한 뒤 double 타입으로 변환
        double left = ((Number)p1.getX()).doubleValue();
        double right = ((Number)p2.getX()).doubleValue();

        // p1의 y좌표를 Number로 변환한 뒤 double 타입으로 변환
        double top = ((Number)p1.getY()).doubleValue();
        double bottom = ((Number)p2.getY()).doubleValue();

        // 사각형의 너비와 높이 계산
        double width = right - left;
        double height = bottom - top;

        // 넓이 반환
        return width * height;
    }

    public static void main(String[] args) {
        // Point 객체 생성 (x: Integer, y: Double 타입 사용)
        Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
        Point<Integer, Double> p2 = new Point<>(10, 10.0); // 타입 생략 가능 (Java 7부터)

        // 제네릭 메서드 호출
        double rect = GenericMethod.<Integer, Double>makeRectangle(p1, p2);

        // 결과 출력
        System.out.println("두 점으로 만들어진 사각형의 넓이는 " + rect + "입니다.");
    }
}
