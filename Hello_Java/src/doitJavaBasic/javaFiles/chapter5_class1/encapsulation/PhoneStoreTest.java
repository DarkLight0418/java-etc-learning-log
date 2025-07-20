package doitJavaBasic.files.chapter5_class1.encapsulation;

public class PhoneStoreTest {
    public static void main(String[] args) {
        Phone phone = new Phone("LG폰", 100000);
        PhoneStore store = new PhoneStore(phone);
        Customer customer = new Customer("김민영", 100000);
        customer.buyPhone(store);
    }
}
