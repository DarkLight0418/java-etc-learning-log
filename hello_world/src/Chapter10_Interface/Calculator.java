package Chapter10_Interface;

// Calc 인터페이스를 구현하는 추상 클래스
public abstract class Calculator implements Calc {

    // add() 메서드 구현 - 두 정수를 더하는 기능을 수행
    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // substract() 메서드 구현 - 두 정수를 빼는 기능을 수행
    @Override
    public int substract(int num1, int num2) {
        return num1 - num2;
    }
}
