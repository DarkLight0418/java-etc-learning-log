package Chapter8_inheritance.No4_5_polymorphism;
import java.util.ArrayList;

public class CustomerTest2 {
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();

        Customer customerLee = new Customer(10001, "이민혁");
        Customer customerKim = new Customer(10002, "김한수");
        Customer customerYoul = new GoldCustomer(10003, "율비");
        Customer customerHong = new GoldCustomer(10004, "홍명보");
        Customer customerShin = new VIPCustomer(10005, "신짱구", 102);

        // ArrayList의 add 메서드를 사용해 객체 배열에 고객 추가

        customerList.add(customerLee);
        customerList.add(customerKim);
        customerList.add(customerYoul);
        customerList.add(customerHong);
        customerList.add(customerShin);

        System.out.println("====== 고객 정보 출력 ======");
        for (Customer customer : customerList) {
            System.out.println(customer.showCustomerInfo());
        }

        System.out.println("====== 할인율과 보너스 포인트 계산 ======");
        int price = 10000;
        for (Customer customer : customerList) {
            int cost = customer.calcPrice(price);
            System.out.println(customer.getCustomerName() + " 님이 " + cost + "원 지불하셨습니다.");
            System.out.println(customer.getCustomerName() + " 님의 현재 보너스 포인트는 " + customer.bonusPoint + "점입니다.");
        }
    }
}
