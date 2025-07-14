package chapter8_inheritance.No3_overriding;

public class OverridingTest3 {
    public static void main(String[] args) {
        int price = 10000;

        Customer customerKim = new Customer(10010, "김민우");
        System.out.println(customerKim.getCustomerName()
                + " 님이 지불해야 하는 금액은 " + customerKim.calcPrice(price) + "원입니다.");

        VIPCustomer customerSon = new VIPCustomer(10020, "손흥민", 12534);
        System.out.println(customerSon.getCustomerName() + " 님이 지불해야 하는 금액은 "
        + customerSon.calcPrice(price) + "원입니다.");

        Customer vc = new VIPCustomer(10030, "심정은", 2000);
        System.out.println(vc.getCustomerName() + " 님이 지불해야 하는 금액은 " + vc.calcPrice(10000) + "원입니다.");
    }
}
