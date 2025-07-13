package Chapter8_inheritance.No3_overriding;

public class Temp1_20250423 {
    int num;

    void number() {
        System.out.println("number() 출력 - num 값: " + num);
    }

    int numberInt(int a) {
        num += a;
        System.out.println(num);
        return num;
    }

    public static void main(String[] args) {
        Temp1_20250423 a1 = new Temp1_20250423();
        Temp1_20250423 a2 = new Temp1_20250423();
        Temp1_20250423 a3 = new Temp1_20250423();

        // 각 객체의 num 값을 다르게 설정
        a1.num = 10;
        a2.num = 20;
        a3.num = 30;

        a3.numberInt(23);

        // 각 객체의 aaa 메서드를 호출해 보면 서로 다른 num 값을 출력함
        a1.number();  // aaa() 출력 - num 값: 10
        a2.number();  // aaa() 출력 - num 값: 20

        // 주소값 비교로 서로 다른 인스턴스인지 확인
        System.out.println("a1 == a2? " + (a1 == a2));  // false
        System.out.println(a1.equals(a2));
        System.out.println(a3.num);
    }
}

