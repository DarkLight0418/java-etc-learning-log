package doitJavaBasic.files.chapter6_class2.no2_cooperation;

public class Bus {
    int busNumber;  // 버스 번호
    int passengerCount;  // 승객 수
    int money;  // 버스 수입

    public Bus(int busNumber) {
        this.busNumber = busNumber;  // 버스 번호를 매개변수로 받는 생성자
    }

    public void take(int money) {  // 숭객이 버스 탑승 시의 경우를 구현한 메서드
        this.money += money;  // 버스 수입 증가
        passengerCount++;  // 승객 수 증가
    }

     public void showInfo() {
         System.out.println("버스 " + busNumber + "번의 승객은 " + passengerCount + "명이고, 수입은 " + money + "입니다.");
     }
}
