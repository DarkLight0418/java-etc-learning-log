package chapter6_class2.no3_static; // 패키지 선언

// Student2 클래스 정의
public class Student2 {
    private static int serialNum = 1000; // 모든 객체가 공유하는 static 변수 (초기값: 1000)
    int studentID; // 학생 ID (각 객체별로 개별적인 변수)
    String studentName; // 학생 이름
    int grade; // 학년
    String address; // 주소

    // 기본 생성자
    public Student2() {
        serialNum++; // 새로운 객체가 생성될 때마다 serialNum 증가
        studentID = serialNum; // 증가된 serialNum 값을 studentID에 할당
    }

    // 학생 이름을 반환하는 메서드 (getter)
    public String getStudentName() {
        return studentName;
    }

    // 학생 이름을 설정하는 메서드 (setter)
    public void setStudentName(String name) {
        studentName = name;
    }

    // serialNum 값을 반환하는 정적 메서드 (클래스 메서드)
    public static int getSerialNum() {
        int i = 10; // 지역 변수 i 선언 (사용되지 않음)
        return serialNum; // static 변수 serialNum 반환
    }

    // serialNum 값을 설정하는 정적 메서드 (클래스 메서드)
    public static void setSerialNum(int serialNum) {
        Student2.serialNum = serialNum; // 클래스 변수 serialNum 값 변경
    }
}
