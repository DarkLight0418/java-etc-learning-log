package Chapter15_IO.stream.decorator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
    public static void main(String[] args) {
        long milliSecond = 0;
        try (FileInputStream fis = new FileInputStream("a.zip");
             FileOutputStream fos = new FileOutputStream("copy.zip")) {
            milliSecond = System.currentTimeMillis();  // 파일 복사를 시작하기 직전의 시간을 기록
            int i;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            milliSecond = System.currentTimeMillis() - milliSecond;  // 파일을 복사하는 데 걸린 시간 계산
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("파일 복사하는 데 " + milliSecond + "밀리세컨드 소요되었습니다.");
    }
}