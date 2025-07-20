package chapter6_class2.no3_static;

public class StudentTest3 {
    public static void main(String[] args) {
        Student1 studentKim = new Student1();
        studentKim.setStudentName("김민재");
        System.out.println(Student1.serialNum);
        System.out.println(studentKim.studentName + "학번 :" + studentKim.studentID);  // serialNum 변수의 초깃값 출력

        Student1 studentSon = new Student1();
        studentSon.setStudentName("손흥민");
        System.out.println(Student1.serialNum);
        System.out.println(studentSon.studentName + "학번 :" + studentSon.studentID);
    }
}
