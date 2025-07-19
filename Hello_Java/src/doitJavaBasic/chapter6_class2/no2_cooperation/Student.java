package doitJavaBasic.chapter6_class2.no2_cooperation;

public class Student {
    public String studentName;  // 학생 이름
    public int grade;   // 학년
    public int money;   // 가진 돈

    public Student(String studentName, int money) {  // 학생 이름 및 가진 돈을 매개변수로 받는 생성자
        this.studentName = studentName;
        this.money = money;
    }

    public void takeBus(Bus bus) {  // 버스를 타면 1000원 지불하는 메서드
        bus.take(1000);
        this.money -= 1000;
    }

    public void takeSubway(Subway subway) { // 전철을 타면 1500원 지불하는 메서드
        subway.take(1500);
        this.money -= 1500;
    }

    public void showInfo() {  // 학생의 현재 정보를 출력하는 메서드
        System.out.println(studentName + " 님의 남은 돈은 " + money + "입니다.");
    }
}