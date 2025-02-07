package chapter5_class1;

public class Student {  // 클래스 이름 (class - 클래스를 만드는 예약어)
    int studentID;
    String studentName;
    int grade;
    String address;  // 상위 4개 멤버 변수

    public String getStudentName() {
        return studentName;   // studentName을 반환하는 get( ) 메서드 구현
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    public static void main(String[] args) {
        Student studentAhn = new Student();
        studentAhn.studentName = "안연수";

        System.out.println(studentAhn.studentName);
        System.out.println(studentAhn.getStudentName());
    }
}
    /*    public void showStudentInfo( ) {
        System.out.println(studentName + "," + address);  // 이름, 주소 출력
    }
} */