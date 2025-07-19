package chapter5_class1.encapsulation;

public class PhoneStore {
    private Phone phone;  // phone : 대리점에서 판매하는 핸드폰을 의미하는 Phone의 객체

    public PhoneStore(Phone phone) {  // PhoneStore 객체를 생성할 때 호출
        this.phone = phone;
    }

    // 구입하려는 모델과 예산이 매개변수

    public Phone sellPhone(String model, double budget) {
        String phoneModel = phone.getModel();

        // 고객이 원하는 모델과 대리점에서 가지고 있는 핸드폰 모델이 같고,
        // 핸드폰의 가격이 예산보다 작거나 같을 시,

        if (model.equals(phoneModel) && budget >= phone.getPrice()) {
            registerPayment();
            discountPromotion();
            saveData();
            return phone;
        }
        else return null;
    }
    private void registerPayment() {
        System.out.println("대리점 : 요금제를 등록합니다. 약정을 등록합니다.");
    }

    private void discountPromotion() {
        System.out.println("대리점 : 프로모션을 적용하여 할인시킵니다.");
    }

    private void saveData() {
        System.out.println("대리점 : 데이터 저장 후 새로운 폰으로 이동합니다.");
    }
}
