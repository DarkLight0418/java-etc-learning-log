package Chapter11_JDKBasicClass.No3_Enum;

public enum GameLevel {
    BEGINNER_LEVEL(1, "초보자"),
    ADVANCED_LEVEL(2, "숙련자"),
    SUPER_LEVEL(3, "고수");

    private int level;
    private String hint;
    // 상수가 가질 수 있는 속성을 인스턴스 변수로 선언

    GameLevel(int level, String hint) {
        this.level = level;
        this.hint = hint;
    }

    public int getLevel() {
        return level;
    }

    public String getHint() {
        return hint;
    }

    public String toString() {
        return getHint();
    }

    public static void main(String[] args) {
        /*  GameLevel[] gameLevels = GameLevel.values();
            for (GameLevel level : gameLevels) {
               System.out.println(level);
        } */
        GameLevel gameLevel = GameLevel.valueOf("BEGINNER_LEVEL");
        System.out.println(gameLevel.getLevel());
        System.out.println(gameLevel.getHint());
    }
}
