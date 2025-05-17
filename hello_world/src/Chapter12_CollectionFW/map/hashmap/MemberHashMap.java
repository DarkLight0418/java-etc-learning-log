package Chapter12_CollectionFW.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;

import Chapter12_CollectionFW.collection.Member;

public class MemberHashMap {
    private HashMap<Integer, Member> hashMap;
    
    public MemberHashMap() {
        hashMap = new HashMap<Integer, Member>();
    }
    
    public void addMember(Member member) {  // HashMap에 회원을 추가하는 메서드
        hashMap.put(member.getMemberID(), member);  // key-value 쌍으로 추가
    }
    
    public boolean removeMember(int memberID) {   // HashMap에서 회원을 삭제하는 메서드
        if (hashMap.containsKey(memberID)) {  // HashMap에 매개변수로 받은 key값인 회원 아이디가 있다면
            hashMap.remove(memberID);  // 회원 아이디 삭제
            return true;
        }
        System.out.println(memberID + "가 존재하지 않습니다");
        return false;
    }
    
    public void showAllMember() {  // Iterator를 사용해 전체 회원을 출력하는 메서드
        Iterator<Integer> ir = hashMap.keySet().iterator();
        while (ir.hasNext()) {  // 다음 key가 있으면
            int key = ir.next();  // key 값을 가져와서
            Member member = hashMap.get(key);  // key로부터 value 가져오기
            System.out.println(member);
        }
        System.out.println( );
    }
}
