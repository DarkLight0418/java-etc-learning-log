package Chapter15_IO.stream.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamTest {
    public static void main(String[] args) {
        long milliSecond = 0;
        try (FileInputStream fis = new FileInputStream("a.zip");
        FileOutputStream fos = new FileOutputStream("copy.zip");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos)) {
         milliSecond = System.currentTimeMillis();

         int i;

         while ((i = bis.read()) != -1) {
             bos.write(i);
         }
         milliSecond = System.currentTimeMillis() - milliSecond;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("파일 복사하는 데 " + milliSecond + " 밀리초 소요되었습니다.");
    }
}
