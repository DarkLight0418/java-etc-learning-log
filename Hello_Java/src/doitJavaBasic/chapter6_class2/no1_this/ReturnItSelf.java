package chapter6_class2.no1_this;

class Student {
    private int id;
    private String name;
    private int grade;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public Student setId(int id) {  // this로 현재 객체를 참조해서 인스턴스 변수 id를 매개변수로 설정 후 이를 반환
        this.id = id;
        return this;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
    public Student setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public void showStudentInfo() {
        System.out.println(name + " 님의 학번은 " + id + "이고, " + grade + "학년입니다.");
    }
}


public class ReturnItSelf {
    public static void main(String[] args) {
        Student studentLee = new Student();
        studentLee.setId(202388444).setName("안지연").setGrade(3).showStudentInfo();
        // 연속 호출
    }
}
