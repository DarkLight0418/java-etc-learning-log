package Chapter9_AbstractClass.No3_Application;

public class BeginnerLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("천천히 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("점프 아직 불가능");
    }

    @Override
    public void turn() {
        System.out.println("턴 아직 불가능");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("***** 초급자 레벨입니다 *****");
    }
}
