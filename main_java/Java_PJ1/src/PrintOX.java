import java.util.Scanner;

public class PrintOX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 스캐너 변수
        int line, i, j, k;  // 필요한 int형 변수들, i는 현재 줄 번호(0부터 시작)

        while(true) {  // 숫자 입력 반복문
            System.out.print("숫자 입력: ");
            line = sc.nextInt();  // 스캐너를 통해 line에 수 저장
            if (line > 0)   // 조건문(0이 입력되는 경우 처리)
                break;
            else
                System.out.println("0보다 큰 숫자를 입력하세요 :");
        }

        for(i = 0; i < line; i++) {  // OX 출력문
            // 바깥 반복문: 전체 줄 수(line)만큼 반복 → i는 현재 줄 번호(0부터 시작)
            for(j = 0; j < line -(i+1); j++) {
                // 첫 번째 안쪽 반복문: 현재 줄에서 O를 출력
                // O의 개수는 "전체 줄 수 - (현재 줄 번호 + 1)"
                System.out.print("O");
            }
            for(k = 0; k < line - j; k++) {
                // 두 번째 안쪽 반복문: 현재 줄에서 X를 출력
                // X의 개수는 "전체 줄 수 - 위에서 출력한 O의 개수(j)"
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
