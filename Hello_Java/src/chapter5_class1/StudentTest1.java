package chapter5_class1;

public class StudentTest1 {
    public static void main(String[] args) {
        Student student1 = new Student(); // 1번째 학생 생성
        // student1.studentName = "김민혁";
        student1.setStudentName("김민혁");
        System.out.println(student1.getStudentName());
        
        Student student2 = new Student(); // 2번째 **
        // student2.studentName = "송지민";
        student2.setStudentName("송지민");
        
        System.out.println(student2.getStudentName());

        System.out.println(student1);
        System.out.println(student2);  // 참조 변숫값 출력
    }
}
