package Chapter8_inheritance.No3_overriding;

public class OverridingTest1 {
    public static void main(String[] args) {
        Customer customerSin = new Customer(10010, "신짱구");
        customerSin.bonusPoint = 1000;

        VIPCustomer customerKim = new VIPCustomer(10011, "김철수", 204);
        customerKim.bonusPoint = 10000;

        int price = 10000;
        System.out.println(customerSin.getCustomerName() + "님이 지불해야 하는 금액은 "
                + customerSin.calcPrice(price) + "원입니다.");
        System.out.println(customerKim.getCustomerName() + "님이 지불해야 하는 금액은 "
                + customerKim.calcPrice(price) + "원입니다.");
    }
}
