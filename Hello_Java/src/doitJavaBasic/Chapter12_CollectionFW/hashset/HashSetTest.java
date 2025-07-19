package Chapter12_CollectionFW.hashset;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add(new String("김민우"));
        hashSet.add(new String("진성진"));
        hashSet.add(new String("홍연의"));
        hashSet.add(new String("김민우"));   // 중복되는 문자열
        hashSet.add(new String("김만기"));

        System.out.println(hashSet);  // 자료 순서 상관없이 출력
    }
}
