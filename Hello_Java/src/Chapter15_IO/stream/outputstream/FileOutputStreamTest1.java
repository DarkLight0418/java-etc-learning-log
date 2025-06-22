package Chapter15_IO.stream.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            fos.write(65);
            fos.write(66);
            fos.write(67);
            // FileOutputStream은 파일에 숫자를 쓰면 해당하는 알파벳으로 변환됨
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("출력이 완료되었습니다.");
    }
}