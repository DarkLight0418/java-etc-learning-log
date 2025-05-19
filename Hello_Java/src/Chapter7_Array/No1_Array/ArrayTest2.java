package Chapter7_Array.No1_Array;

public class ArrayTest2 {
    public static void main(String[] args) {
        double[] data = new double[5];

        data[0] = 10.0;  // 첫 번째 요소에 값 10.0 대입
        data[1] = 20.0;  // 두 번째 요소에 값 20.0 대입
        data[2] = 30.0;

        for (int i = 0; i < data.length; i++) {  // 전체 배열 길이만큼 반복
            System.out.println(data[i]);
        }
    }
}
