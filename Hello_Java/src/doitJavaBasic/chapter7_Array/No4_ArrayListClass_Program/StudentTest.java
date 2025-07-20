package chapter7_Array.No4_ArrayListClass_Program;

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee = new Student(1001, "Lee");
        studentLee.addSubject("국어", 90);
        studentLee.addSubject("수학", 80);

        Student studentKim = new Student(1002, "Kim");
        studentKim.addSubject("국어", 100);
        studentKim.addSubject("수학",85);
        studentKim.addSubject("영어",95);

        studentLee.showStudentInfo();
        System.out.println("====================================");
        studentKim.showStudentInfo();
    }
}
