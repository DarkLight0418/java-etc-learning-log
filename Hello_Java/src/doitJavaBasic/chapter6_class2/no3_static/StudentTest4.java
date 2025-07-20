package chapter6_class2.no3_static;

public class StudentTest4 {
    public static void main(String[] args) {
        Student2 studentLee = new Student2();
        studentLee.setStudentName("이재성");
        System.out.println(Student2.getSerialNum());
        System.out.println(studentLee.studentName + " 학번:" + studentLee.studentID);

        Student2 studentSon = new Student2();
        studentLee.setStudentName("손흥민");
        System.out.println(Student2.getSerialNum());
        System.out.println(studentLee.studentName + " 학번:" + studentSon.studentID);
    }
}
