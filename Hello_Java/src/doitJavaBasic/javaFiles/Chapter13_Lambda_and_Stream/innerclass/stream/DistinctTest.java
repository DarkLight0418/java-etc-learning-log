package Chapter13_Lambda_and_Stream.innerclass.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Student{
    private int ID;
    private String name;

    public Student(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}

public class DistinctTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100, "이범석");
        Student studentMoon = new Student(200, "문현종");
        Student studentLee2 = new Student(100, "이범석");

        List<Student> studentList = new ArrayList<>();
        studentList.add(studentLee);
        studentList.add(studentMoon);
        studentList.add(studentLee2);
        
        studentList.stream()
                .map(Student::getName)
                .distinct()
                .forEach(s -> System.out.println(s));
        
        // map() 연산으로 조건에 맞는 요소를 찾고 그 중 동일한 이름을 제외하고 출력
    }
}
