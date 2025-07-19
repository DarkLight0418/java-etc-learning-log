package Chapter12_CollectionFW.hashset;

import java.util.HashSet;
import java.util.Iterator;

import Chapter12_CollectionFW.collection.Member;

public class MemberHashSet {
    private HashSet<Member> hashSet;   // hashSet 선언
    
    public MemberHashSet() {
        hashSet = new HashSet<Member>();  // HashSet 생성
    }
    
    public void addMember(Member member) {
        hashSet.add(member);
        
    }
    
    public boolean removeMember(int memberID) {
        Iterator<Member> ir = hashSet.iterator();
        // Iterator를 활용해 HashSet 요소 순회
        
        while (ir.hasNext()) {
            Member member = ir.next();  // 회원을 하나씩 가져와서
            int tempID = member.getMemberID();   // 아이디 비교
            if (tempID == memberID) {  // 같은 아이디인 경우
                hashSet.remove(member);  // 회원 삭제
                return true;
            }
        }
        System.out.println(memberID + "가 존재하지 않습니다.");
        return false;
    }
    
    // 매개변수로 받은 회원 아이디에 해당하는 회원 삭제
    
    public void showAllMember() {  // 모든 회원 출력
        for (Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println( );
    }
}
