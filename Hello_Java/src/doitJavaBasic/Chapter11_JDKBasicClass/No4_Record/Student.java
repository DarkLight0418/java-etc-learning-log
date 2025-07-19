package Chapter11_JDKBasicClass.No4_Record;

// java.util.Objects는 equals, hashCode 등을 간편하게 구현하기 위해 사용됩니다.
import java.util.Objects;

// 학생 정보를 저장하는 클래스 정의
public class Student {
    // 학생의 고유 ID
    private int id;

    // 학생의 이름
    private String name;

    // 생성자: 객체 생성 시 ID와 이름을 초기화함
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // ID를 외부에서 읽을 수 있도록 하는 getter 메서드
    public int getId() {
        return id;
    }

    // 이름을 외부에서 읽을 수 있도록 하는 getter 메서드
    public String getName() {
        return name;
    }

    // 이름을 외부에서 변경할 수 있도록 하는 setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    // equals 메서드 오버라이드: 두 객체가 같은지를 비교하는 방법을 정의함
    @Override
    public boolean equals(Object o) {
        // 현재 객체와 매개변수 객체가 같은 주소를 참조하는 경우 true 반환
        if (this == o) return true;

        // 매개변수가 null이거나 클래스가 다른 경우 false 반환
        if (o == null || getClass() != o.getClass()) return false;

        // 다운캐스팅 후 각각의 필드를 비교하여 같으면 true 반환
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    // hashCode 메서드 오버라이드: 해시 값을 생성함 (equals와 함께 사용됨)
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // toString 메서드 오버라이드: 객체 정보를 문자열로 표현
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // main 메서드: 클래스의 테스트 및 실행을 위한 코드
    public static void main(String[] args) {
        // Student 객체 studentSin 생성 (id: 15555, name: "신짱구")
        Student studentSin = new Student(15555, "신짱구");

        // Student 객체 studentKim 생성 (id: 15556, name: "김철수")
        Student studentKim = new Student(15556, "김철수");

        // studentSin 객체의 내용을 출력 (toString 메서드 호출됨)
        System.out.println(studentSin);

        // studentSin과 studentKim이 같은지 비교하고 결과 출력 (equals 메서드 사용)
        System.out.println(studentSin.equals(studentKim));

        // studentKim의 이름을 "김신영"으로 변경
        studentKim.setName("김신영");

        // 변경된 이름을 출력
        System.out.println(studentKim.getName());
    }
}
