package Chapter9_AbstractClass.No3_Application;

// 플레이어의 레벨을 관리하는 클래스
public class Player {
    private PlayerLevel level; // 플레이어의 현재 레벨을 저장하는 변수

    // 생성자: Player 객체가 생성될 때 기본적으로 BeginnerLevel을 설정
    public Player() {
        level = new BeginnerLevel(); // 처음에는 초보자 레벨로 시작
        level.showLevelMessage(); // 현재 레벨 메시지 출력
    }

    // 현재 플레이어의 레벨을 반환하는 메서드
    public PlayerLevel getLevel() {
        return level;
    }

    // 플레이어의 레벨을 업그레이드하는 메서드
    public void upgradeLevel(PlayerLevel level) {
        this.level = level; // 새로운 레벨로 변경
        level.showLevelMessage(); // 새로운 레벨 메시지 출력
    }

    // 플레이어가 특정 횟수만큼 게임을 플레이하도록 하는 메서드
    public void play(int count) {
        level.go(count); // 현재 레벨에 따라 동작 수행
    }
}
