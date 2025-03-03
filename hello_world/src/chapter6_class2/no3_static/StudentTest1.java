package chapter6_class2.no3_static;

public class StudentTest1 {
    public static void main(String[] args) {
        Student studentLee = new Student();
        studentLee.setStudentName("김민재");
        System.out.println(studentLee.serialNum);  // serialNum 변수의 초깃값 출력
        studentLee.serialNum++;  // static 변숫값 증가

        Student studentSon = new Student();
        studentSon.setStudentName("손흥민");
        System.out.println(studentSon.serialNum);  // 증가한 값들 출력
        System.out.println(studentLee.serialNum);
    }
}
