public class Professor {
    String name;
    String position;
    int subjectPoint;

    void callName() {
        System.out.println("출석 부르기");
    }

    void publishAssignment() {
        System.out.println("과제 내주기");
    }

    int getPoint(int point) {
        System.out.println("자네의 점수는 " + point + "점이라네");
        return point;
    }

    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.callName();
        professor.publishAssignment();
        int pp = professor.getPoint(80);

        System.out.println(pp+"점");
    }
}
