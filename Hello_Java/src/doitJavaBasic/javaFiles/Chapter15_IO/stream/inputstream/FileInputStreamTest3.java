package Chapter15_IO.stream.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input2.txt")) {
            byte[] bs = new byte[10];  // 크기가 10인 바이트 배열 생성
            int i;

            while ((i = fis.read(bs)) != -1) {
                for (int k = 0; k < i; k++) {   // 기존 byte b : bs
                    System.out.print((char)bs[k]);
                }
                System.out.println(": " + i + "바이트 읽음");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
