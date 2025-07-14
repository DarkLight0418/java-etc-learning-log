package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryCatchTest {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void m1() {
        try {
            System.out.println("(1)");
            System.out.print("나이: ");
            String line = br.readLine();
            System.out.println("(2)");
            int age = Integer.parseInt(line);
            System.out.println("읽은 나이: " + age);
            System.out.println("(3)");
        } catch (IOException ie) {
            System.out.println("(4)");
        } catch (NumberFormatException ne) {
            System.out.println("(5)");
            System.out.println("숫자만 가능");
            m1();
        } finally {
            System.out.println("(6)");
        }
        System.out.println("(7)");
    }

    public static void main(String[] args) {
        TryCatchTest tk = new TryCatchTest();
        tk.m1();
    }
}
