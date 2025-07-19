package chapter5_class1; // 패키지 선언

public class Student4 {
    int studentID; // 학생 ID
    String studentName; // 학생 이름
    Subject2 korean; // 국어 과목 객체
    Subject2 math; // 수학 과목 객체

    // 생성자: 학생 ID와 이름을 받아 객체를 생성
    public Student4(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;

        // 국어와 수학 과목 객체를 생성
        korean = new Subject2();
        math = new Subject2();
    }

    // 학생의 성적 정보를 출력하는 메서드
    public void showStudentInfo() {
        System.out.println(studentName + "님의 " + korean.getSubjectName() + " 과목의 점수는 "
                + korean.getScorePoint() + "점이며 " + math.getSubjectName() + " 과목의 점수는 " + math.getScorePoint() + "점입니다.");
    }

    // 국어 과목의 과목명과 점수를 설정하는 메서드
    public void setKoreanSubject(String subjectName, int score){
        korean.setSubjectName(subjectName);
        korean.setScorePoint(score);
    }

    // 수학 과목의 과목명과 점수를 설정하는 메서드
    public void setMathSubject(String subjectName, int score) {
        math.setSubjectName(subjectName);
        math.setScorePoint(score);
    }
}
