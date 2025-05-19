package chapter5_class1.encapsulation;

public class Phone {
    private String model;
    private double price;  // 두 인스턴스 변수를 private 선언

    public Phone(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}
