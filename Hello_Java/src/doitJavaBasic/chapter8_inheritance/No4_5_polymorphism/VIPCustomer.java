package chapter8_inheritance.No4_5_polymorphism;

// VIP 고객 정보를 관리하는 VIPCustomer 클래스
// Customer 클래스를 상속받아 VIP 고객에게 추가 혜택을 제공
public class VIPCustomer extends Customer {
    private int agentID;  // VIP 고객의 담당 상담원 ID
    double saleRatio;     // VIP 고객이 받을 할인율

    // VIPCustomer 생성자: 고객 ID, 고객 이름, 담당 상담원 ID를 매개변수로 받음
    public VIPCustomer(int customerID, String customerName, int agentID) {
        super(customerID, customerName); // 부모 클래스(Customer)의 생성자 호출

        // VIP 고객을 위한 추가 설정
        customerGrade = "VIP";  // VIP 등급 설정
        bonusRatio = 0.05;       // VIP 고객은 5%의 보너스 포인트 적립
        saleRatio = 0.1;         // VIP 고객은 10% 할인 혜택
        this.agentID = agentID;  // 담당 상담원 ID 설정
    }

    // 제품 구매 시, 할인 적용 및 보너스 포인트 적립 (메서드 오버라이딩)
    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;   // 보너스 포인트 적립
        return price - (int)(price * saleRatio);  // 할인된 가격 반환
    }

    // 고객 정보를 문자열로 반환하는 메서드 (메서드 오버라이딩)
    @Override
    public String showCustomerInfo() {
        // 부모 클래스의 showCustomerInfo() 결과에 상담원 정보 추가
        return super.showCustomerInfo() + " 담당 상담원 아이디는 " + agentID + "입니다.";
    }

    // 담당 상담원 ID를 반환하는 getter 메서드
    public int getAgentID() {
        return agentID;
    }
}
