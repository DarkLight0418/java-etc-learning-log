package Chapter11_JDKBasicClass.No5_Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StringClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName() 메서드는 문자열로 클래스 이름을 받아 해당 클래스의 Class 객체를 반환함
        // 이 경우 "java.lang.String" 클래스의 메타 정보를 가져오는 것
        Class strClass = Class.forName("java.lang.String");

        // 1. 생성자(Constructor) 정보 출력
        // getConstructors()는 public 접근 제한자를 가진 생성자들만 반환
        Constructor[] cons = strClass.getConstructors();
        for (Constructor c : cons) {
            System.out.println(c);  // 각각의 생성자 시그니처 출력
        }

        System.out.println();

        // 2. 필드(Field) 정보 출력
        // getFields()는 public 접근 제한자를 가진 필드(멤버 변수)만 반환
        Field[] fields = strClass.getFields();
        for (Field f : fields) {
            System.out.println(f);  // 각 필드의 타입, 이름 등을 출력
        }

        System.out.println();

        // 3. 메서드(Method) 정보 출력
        // getMethods()는 public 접근 제한자를 가진 메서드들을 모두 반환 (상속된 메서드 포함)
        Method[] methods = strClass.getMethods();
        for (Method m : methods) {
            System.out.println(m);  // 각 메서드의 반환형, 이름, 파라미터 등 시그니처 출력
        }
    }
}
