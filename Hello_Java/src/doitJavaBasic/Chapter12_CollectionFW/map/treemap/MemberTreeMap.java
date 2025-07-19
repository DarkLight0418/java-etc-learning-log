package Chapter12_CollectionFW.map.treemap;

// 필요한 클래스 import
import java.util.Iterator;           // 반복자 사용을 위한 import
import java.util.TreeMap;            // TreeMap 클래스 사용을 위한 import

import Chapter12_CollectionFW.collection.Member; // 사용자 정의 Member 클래스 import

// Member 객체를 TreeMap을 이용해 관리하는 클래스
public class MemberTreeMap {
    // TreeMap 선언: Key는 회원의 ID(Integer), Value는 Member 객체
    private TreeMap<Integer, Member> treeMap;

    // 생성자: TreeMap 객체를 생성함
    public MemberTreeMap() {
        treeMap = new TreeMap<Integer, Member>();
    }

    // 새로운 회원을 TreeMap에 추가하는 메서드
    public void addMember(Member member) {
        // 회원의 ID를 key로, Member 객체를 value로 저장
        // TreeMap은 key 값을 기준으로 정렬된 상태로 데이터를 저장함 (기본적으로 오름차순)
        treeMap.put(member.getMemberID(), member);
    }

    // 회원을 TreeMap에서 삭제하는 메서드
    public boolean removeMember(int memberID) {
        // 먼저 해당 ID가 TreeMap에 존재하는지 확인
        if (treeMap.containsKey(memberID)) {
            treeMap.remove(memberID); // 해당 key(회원 ID)에 해당하는 데이터를 삭제
            return true;              // 삭제 성공 시 true 반환
        }
        // ID가 존재하지 않는 경우
        System.out.println(memberID + "가 존재하지 않습니다.");
        return false; // 삭제 실패 시 false 반환
    }

    // TreeMap에 저장된 모든 회원 정보를 출력하는 메서드
    public void showAllMember() {
        // keySet()을 통해 key값들(회원 ID)을 가져오고, Iterator로 순회
        Iterator<Integer> ir = treeMap.keySet().iterator();
        while (ir.hasNext()) {
            int key = ir.next();           // 현재 key값 가져오기
            Member member = treeMap.get(key); // key에 해당하는 Member 객체 가져오기
            System.out.println(member);    // Member 클래스의 toString() 메서드가 호출됨
        }
        System.out.println(); // 줄바꿈
    }
}
