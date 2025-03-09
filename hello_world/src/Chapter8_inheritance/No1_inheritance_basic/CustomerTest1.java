package Chapter8_inheritance.No1_inheritance_basic;

public class CustomerTest1 {
    public static void main(String[] args) {
        Customer customerLee = new Customer();
        customerLee.setCustomerID(1033);  // customerID, customerName은 protected 변수이므로 set() 메서드 호출
        customerLee.setCustomerName("이민주");
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showCustomerInfo());

        VIPCustomer customerSin = new VIPCustomer();
        customerSin.setCustomerID(1034);
        customerSin.setCustomerName("신짱구");
        customerSin.bonusPoint = 20000;
        System.out.println(customerSin.showCustomerInfo());
    }
}
