package Chapter8_inheritance.No3_overriding;

public class VIPCustomer extends Customer {  // VIPCustomer 클래스는 Customer 클래스를 상속받음
    private int agentID;
    double saleRatio;

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;  // 보너스 포인트 적립
        return price - (int) (price * saleRatio);  // 할인율을 적용한 가격 반환
    }

    public VIPCustomer(int customerID, String customerName, int agentID) {
        super(customerID, customerName);
        customerGrade = "VIP";
        bonusRatio = 0.05;
        saleRatio = 0.1;
        this.agentID = agentID;
        System.out.println("VIPCustomer() 생성자 호출");  // 하위 클래스를 생성할 때 출력되는 콘솔 출력문
    }

    public int getAgentID() {
        return agentID;
    }
}
