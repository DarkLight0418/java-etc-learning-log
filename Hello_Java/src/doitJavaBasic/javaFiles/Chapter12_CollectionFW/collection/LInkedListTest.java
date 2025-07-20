package Chapter12_CollectionFW.collection;

import java.util.LinkedList;

public class LInkedListTest {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<String>();

        myList.add("A");
        myList.add("B");
        myList.add("C");
        // 요소 추가

        System.out.println(myList);
        // 리스트 전체 출력

        myList.add(1, "D");
        // 두번째 위치에 D 추가
        System.out.println(myList);

        myList.addFirst("0");
        // 리스트의 맨 앞에 0 추가
        System.out.println(myList);

        System.out.println(myList.removeLast());
        // 링크드리스트의 맨 뒤 요소 삭제 후 삭제된 요소를 출력
        System.out.println(myList);
    }
}
