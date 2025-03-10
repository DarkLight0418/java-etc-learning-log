package Chapter8_inheritance.No1_inheritance_basic;

public class CustomerTest2 {
    public static void main(String[] args) {
        VIPCustomer customerKim = new VIPCustomer(10132, "김신영", 203);  // 하위 클래스 생성
        /* customerKim.setCustomerName("김신영");
        customerKim.setCustomerID(10132); */
        customerKim.bonusPoint = 10000;
        System.out.println(customerKim.showCustomerInfo());
    }
}
