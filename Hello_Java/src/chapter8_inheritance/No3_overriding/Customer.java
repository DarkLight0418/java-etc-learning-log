package chapter8_inheritance.No3_overriding;

public class Customer {
    protected int customerID;  // 고객 아이디(이하 인스턴스 변수들)
    protected String customerName;  // 고객 이름
    protected String customerGrade;   // 고객 등급
    protected int bonusPoint;  // 보너스 포인트
    double bonusRatio;  // 적립 비율

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public Customer(int customerID, String customerName) {  // 디폴트 생성자
        this.customerID = customerID;
        this.customerName = customerName;
        customerGrade = "GOLD";  // 기본 고객 등급
        bonusRatio = 0.03;  // 보너스 포인트 기본 적립 비율
        System.out.println("Customer(int, String) 생성자 호출");  // 상위 클래스를 생성할 때 출력되는 콘솔 출력문
    }
    
    public int calcPrice(int price) {   // 보너스 포인트 적립, 지불 가격 계산 메서드
        bonusPoint += price * bonusRatio;  // 보너스 포인트 계산
        return price;
    }

    public String showCustomerInfo() {  // 고객 정보를 반환하는 메서드
        return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
    }
}
