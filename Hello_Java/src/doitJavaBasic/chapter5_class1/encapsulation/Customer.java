package doitJavaBasic.chapter5_class1.encapsulation;

public class Customer {
    private String name;
    private double budget;  // private 이름 예산 속성

    public Customer(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void buyPhone(PhoneStore store) {
        Phone phone = store.sellPhone("LG폰", budget);
        if (phone != null) {
            System.out.println("고객 : 핸드폰 구입이 완료되었습니다.");
        }
        else {
            System.out.println("고객 : 핸드폰을 구입하지 못했습니다.");
        }
    }
}
