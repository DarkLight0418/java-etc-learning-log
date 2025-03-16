package Chapter9_AbstractClass.No1_Abstract;

public class ComputerTest {
    public static void main(String[] args) {
        // Computer c1 = new Computer();  // 추상 클래스는 모든 메서드가 구현되지 않았기에 인스턴스로 생성 불가
        Computer c2 = new DeskTop();
        // Computer c3 = new NoteBook();
        Computer c4 = new MyNoteBook();
    }
}
