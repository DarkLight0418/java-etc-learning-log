package chapter6_class2.no1_this;

// 학생 정보를 저장하는 클래스
public class ThisNewStudent {
    private int id; // 학번
    private String name; // 이름
    private int grade; // 학년
    private String major; // 전공
    private String phoneNumber; // 전화번호

    // private 생성자로 Builder 객체를 이용한 객체 생성만 허용
    private ThisNewStudent(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.grade = builder.grade;
        this.major = builder.major;
        this.phoneNumber = builder.phoneNumber;
    }

    // 정적 내부 클래스 Builder (Builder 패턴 적용)
    public static class Builder {
        private int id;
        private String name;
        private int grade;
        private String major;
        private String phoneNumber;

        // 필수 매개변수(id, name)를 받는 생성자
        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // 선택적 필드 설정 메서드 (체이닝 기법 적용)
        public Builder grade(int grade) {
            this.grade = grade;
            return this; // 현재 Builder 객체를 반환하여 메서드 체이닝을 가능하게 함
        }

        public Builder major(String major) {
            this.major = major;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        // 최종적으로 ThisNewStudent 객체를 생성하는 메서드
        public ThisNewStudent build() {
            return new ThisNewStudent(this);
        }
    }

    // 학생 정보를 출력하는 메서드
    public void showInfo() {
        System.out.println("학번 :" + id);
        System.out.println("이름 :" + name);
        System.out.println("학년 :" + grade);
        System.out.println("전공 :" + major);
        System.out.println("전화번호 :" + phoneNumber);
    }

    // 메인 메서드: Builder 패턴을 이용하여 객체를 생성하고 정보 출력
    public static void main(String[] args) {
        // Builder를 사용하여 학생 객체 생성
        ThisNewStudent student = new Builder(202388777, "이원주")
                .grade(3) // 학년 설정
                .major("컴퓨터공학") // 전공 설정
                .phoneNumber("010-3333-4444") // 전화번호 설정
                .build(); // 객체 생성

        // 학생 정보 출력
        student.showInfo();
    }
}
