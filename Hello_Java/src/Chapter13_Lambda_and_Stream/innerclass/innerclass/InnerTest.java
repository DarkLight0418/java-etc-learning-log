package Chapter13_Lambda_and_Stream.innerclass.innerclass;

class OutClass {  // 외부 클래스
    private int num = 10;  // 외부 클래스 private 변수
    private static int sNum = 20;  // 외부 클래스 정적 변수

    // private InClass inClass;  // 내부 클래스형 변수를 먼저 선언

    /*
    public OutClass() {   // 외부 클래스 디폴트 생성자, 외부 클래스가 생성된 후에 내부 클래스 생성 가능
        inClass = new InClass();
    }
    */

    static class InStaticClass {  // 인스턴스 내부 클래스
        int inNum = 100;  // 내부 클래스의 인스턴스 변수
        static int sInNum = 200;  // 인스턴스 내부 클래스에 정적 변수(자바 16부터 허용)

        // 정적 내부 클래스의 일반 메서드
        void inTest() {
            // num += 10;  // 외부 클래스의 인스턴스 변수는 사용할 수 없으므로 주석 처리
            System.out.println("OutClass num = " + inNum + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수)");
            System.out.println("OutClass sInNum = " + sInNum + "(인스턴스 내부 클래스의 정적 변수)");;

            System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)");
            System.out.println("InStaticClass sInNNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
        }

        static void sTest() {  // 인스턴스 내부 클래스의 정적 메서드(자바 16부터 허용)
            // num += 10;
            // inNum += 10;
            // 외부 클래스와 내부 클래스의 인스턴스 변수는 사용할 수 없으므로 주석 처리
            System.out.println("인스턴스 내부 클래스의 정적 메서드 호출");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
        }
    }

    /*

    public void usingClass() {
        InStaticClass.inTest();
    }

     */
}

public class InnerTest {
    public static void main(String[] args) {

        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        System.out.println("정적 내부 클래스 일반 메서드 호출");
        sInClass.inTest();
        System.out.println( );

        OutClass outClass = new OutClass();
        System.out.println("외부 클래스를 이용하여 내부 클래스 기능 호출");
        // outClass.usingClass(); // 내부 클래스 기능 호출
        System.out.println("인스턴스 내부 클래스 정적 변수 직접 호출 OutClass.InClass.sInNum = " + OutClass.InStaticClass.sInNum);
        OutClass.InStaticClass.sTest();  // 인스턴스 내부 클래스의 정적 메서드 호출
    }
}
