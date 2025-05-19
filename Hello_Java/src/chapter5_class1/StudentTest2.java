package chapter5_class1;

public class StudentTest2 {
    public static void main(String[] args) {
        Student4 studentLee = new Student4(1001, "이승현");

        studentLee.setKoreanSubject("국어", 100);
        studentLee.setMathSubject("수학", 70);

        Student4 studentKim = new Student4(1002, "김현서");

        studentKim.setKoreanSubject("국어", 70);
        studentKim.setMathSubject("수학", 85);

        studentLee.showStudentInfo();
        studentKim.showStudentInfo();
    }
}
