package Chapter13_Lambda_and_Stream.innerclass.stream;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {
    public static void main(String[] args) {
        TravelCustomer customerLee = new TravelCustomer("이승우", 40, 100);
        TravelCustomer customerKim = new TravelCustomer("김민재", 20, 100);
        TravelCustomer customerHong = new TravelCustomer("홍명보", 43, 150);
        // 고객 생성

        List<TravelCustomer> customerList = new ArrayList<>();
        customerList.add(customerLee);
        customerList.add(customerKim);
        customerList.add(customerHong);

        System.out.println("== 고객 명단 추가된 순서대로 출력 ==");
        customerList.stream().map (c -> c.getName()).forEach(s -> System.out.println(s));

        int total = customerList.stream().mapToInt((c -> c.getPrice())).sum();
        System.out.println("총 여행 비용은 " + total + "만 원입니다.");

        System.out.println("== 30세 이상 고객 명단 정렬하여 출력 ==");
        customerList.stream().filter(c -> c.getAge() >= 30)
                .map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));

    }
}
