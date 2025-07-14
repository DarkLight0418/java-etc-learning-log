package chapter7_Array.No2_objectArray;

public class EnhanceForLoop {
    public static void main(String[] args) {
        // 문자열 배열을 생성하고 초기화
        String[] strArray = {"Java", "Android", "C", "JavaScript", "Python"};

        // 향상된 for문을 사용하여 배열 요소를 반복 출력
        for (String lang : strArray) {
            // 현재 배열 요소(lang)를 출력
            System.out.println(lang);
        }
    }
}
