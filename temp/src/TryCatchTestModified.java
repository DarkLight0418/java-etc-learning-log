import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchTestModified {
    // 숫자 2개를 입력받는 메서드 (예외 발생 가능성 있음)
    public static void SIUUU() {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        try {
            System.out.print("a : ");
            int a = sc.nextInt(); // 숫자가 아닌 값을 입력하면 예외 발생

            System.out.print("b : ");
            int b = sc.nextInt(); // 여기도 마찬가지로 예외 발생 가능

            System.out.println("a + b = " + (a + b));
            System.out.println("a / b = " + (a / b));
        } catch (InputMismatchException e) {
            // 사용자가 숫자가 아닌 값을 입력했을 때의 처리
            System.out.println("⚠️ 숫자가 아닌 값을 입력하셨습니다. 프로그램을 다시 실행해주세요.");
        } catch (ArithmeticException e) {
            // 0으로 나눴을 때 (b가 0일 때)
            System.out.println("⚠️ 0으로 나눌 수 없습니다 ㅜㅜ");
        } catch (Exception e) {
            // 그 외의 예외를 처리
            System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
        } finally {
            sc.close(); // Scanner 객체는 사용 후 꼭 닫기
        }
    }

    public static void main(String[] args) {
        // static 메서드이므로 객체 생성 없이 바로 호출 가능
        SIUUU();
    }
}
