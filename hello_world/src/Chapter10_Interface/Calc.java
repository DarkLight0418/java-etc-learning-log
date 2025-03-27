package Chapter10_Interface;

// 인터페이스 선언
// 인터페이스는 다른 클래스들이 구현해야 할 메서드의 명세(틀)만을 제공함.
public interface Calc {

    // 인터페이스에서 선언된 변수는 암묵적으로 public static final이 됨.
    // 즉, 상수로 사용되며 변경할 수 없음.
    double PI = 3.14;
    int ERROR = -999999999;

    // 인터페이스에서 선언된 메서드는 기본적으로 추상 메서드임.
    // public abstract가 생략되어 있어도 자동으로 적용됨.
    int add(int num1, int num2);
    int substract(int num1, int num2);
    int times(int num1, int num2);
    int divide(int num1, int num2);

    default void description() {
        System.out.println("정수 계산기를 구현합니다!");
        myMethod();  // 디폴트 메서드에서 private 메서드 호출
    }

    static int total(int[] arr) {
        int total = 0;

        for (int i : arr) {
            total += i;
        }
        myStaticMethod();
        return total;
    }
    private void myMethod() {  // 사용이나 재정의는 할 수 없으나 여기서 쓰면 자동 실행
        System.out.println("private 메서드입니다.");
    }

    private static void myStaticMethod() {
        System.out.println("private static 메서드입니다.");
    }
}
