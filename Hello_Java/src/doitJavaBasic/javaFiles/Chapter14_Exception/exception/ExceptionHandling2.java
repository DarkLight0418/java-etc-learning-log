package Chapter14_Exception.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling2 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
        } finally {
            if (fis != null) {
                try { fis.close(); }  // 파일 입력 스트림 닫기
                catch (IOException e) {
                    e.printStackTrace();  // 어디에서 예외가 발생했는지 찾아가는 printStackTrace() 메서드 호출
                }
            }
            System.out.println("항상 수행됩니다.(finally문)");
        }
        System.out.println("여기서도 수행됩니다.");
    }
}
