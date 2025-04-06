package Chapter11_JDKBasicClass.No1_Object;

class Student {
    int studentID;
    String studentName;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public String toString() {
        return studentID + "," + studentName;
    }
    
    // equal() 메서드 재정의
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student std = (Student)obj;
            if (this.studentID == std.studentID)  //  재정의한 equals() 메서드는 학생의 학번이 같으면 true 반환
                return true;
            else return false;
        }
        return false;
    }
}


public class EqualsTest {
    public static void main(String[] args) {
        Student studentLee = new Student(100, "이주원");
        Student studentLee2 = studentLee;  // 주소 복사
        Student studentJu = new Student(100, "이주원");

        // 동일한 주소의 두 인스턴스 비교

        if (studentLee == studentLee2)
            System.out.println("둘의 주소가 같습니다.");
        else
            System.out.println("주소가 서로 다릅니다.");

        if (studentLee.equals(studentLee2))
            System.out.println("서로 동일합니다.");
        else
            System.out.println("서로 동일하지 않습니다.");
        // 동일한 주소와 인스턴스 비교
        
        if (studentLee == studentJu) // == 비교
            System.out.println("둘의 주소는 같습니다.");
        else
            System.out.println("주소가 서로 다릅니다.");

        if (studentLee.equals(studentJu))
            System.out.println("서로 동일합니다.");
        else
            System.out.println("서로 동일하지 않습니다.");
    
        // 동일인이지만 인스턴스의 주소가 다른 경우
    }
}
