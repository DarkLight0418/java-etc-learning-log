package doitJavaBasic.javaFiles.chapter3;

public class OperationEx2 {
    public static void main(String[] args) {
        int gameScore = 160;

        int lastScore1 = ++gameScore;
        System.out.println(lastScore1);

        int lastScore2 = --gameScore;
        System.out.println(lastScore2);
    }
}
