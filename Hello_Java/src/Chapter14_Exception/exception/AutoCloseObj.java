package Chapter14_Exception.exception;

public class AutoCloseObj implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("리소스가 close() 되었습니다.");  // close() 메서드 구현
    }
}
