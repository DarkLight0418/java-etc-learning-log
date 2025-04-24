package Chapter11_JDKBasicClass.No5_Class;

public class NewInstanceTest {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        Person person1 = new Person();  // 생성자로 생성하는 경우
        System.out.println(person1);

        Class pClass = Class.forName("Chapter11_JDKBasicClass.No5_Class.Person");
        Person person2 = (Person)pClass.newInstance();  // Class 클래스의 newInstance() 메서드로 생성
        System.out.println(person2);
    }
}
