package doitJavaBasic.files.chapter6_class2.no2_cooperation;

public class Subway {
    String lineName;  // 전철 노선 번호
    int passengerCount;  // 승객 수
    int money;  // 전철 수입

    public Subway(String  lineName) {   // 전철 노선 이름을 매개변수로 받는 생성자
        this.lineName = lineName;
    }

    public void take(int money) {  // 승객이 전철에 탄 경우를 구현한 메서드
        this.money += money;  // 수입 증가
        passengerCount++;  // 승객 수 증가
    }

    public void showInfo() {
        System.out.println(lineName + "의 승객은 " + passengerCount + "명이고, 수입은 " + money + "입니다.");
    }
}
