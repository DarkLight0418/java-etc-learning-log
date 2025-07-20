package chapter6_class2.no5_singleton;

public class CompanyTest {
    public static void main(String[] args) {
        Company myCompany1 = Company.getInstance();  // 클래스 이름으로 getInstance()을 호출하여 참조 변소에 대입
        Company myCompany2 = Company.getInstance();

        System.out.println(myCompany1 == myCompany2);
    }
}
