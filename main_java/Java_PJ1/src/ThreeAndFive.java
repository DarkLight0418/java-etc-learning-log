import java.util.Scanner;

public class ThreeAndFive {
    public static void main(String[] args) {
        int[] tenNumber = new int[10];
        int index3 = 0;
        int index5 = 0;
        System.out.println("수를 10개 입력하세요");
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; ++i) {
            int su = sc.nextInt();
            tenNumber[i] = su;
            if (tenNumber[i] % 3 == 0) {
                index3++;
            } else if (tenNumber[i] % 5 == 0) {
                index5++;
            }
        }

        System.out.println("3의 배수 : " + index3 + ", 5의 배수 : " + index5);
    }
}
