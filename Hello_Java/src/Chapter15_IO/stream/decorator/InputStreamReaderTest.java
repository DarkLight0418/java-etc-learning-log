package Chapter15_IO.stream.decorator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"))) {
            // 보조 스트림인 InputStreamReader의 매개변수로 기반 스트림인 FileInputStream을 받아 생성함
            int i;
            while ((i = isr.read()) != -1) {  // 파일의 끝인 -1이 반환될 때까지 보조 스트림으로 자료를 읽음
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
