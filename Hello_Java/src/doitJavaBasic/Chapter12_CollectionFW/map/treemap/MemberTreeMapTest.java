package Chapter12_CollectionFW.map.treemap;

import Chapter12_CollectionFW.collection.Member;

public class MemberTreeMapTest {
    public static void main(String[] args) {
        MemberTreeMap memberHashMap = new MemberTreeMap();
        
        Member memberPark = new Member(1003, "박지성");
        Member memberSon = new Member(1001, "손흥민");
        Member memberHong = new Member(1002, "홍정호");
        Member memberLee = new Member(1004, "이강인");  // 회원 아이디 순서와 상관없이 회원 추가
        
        memberHashMap.addMember(memberPark);
        memberHashMap.addMember(memberSon);
        memberHashMap.addMember(memberHong);
        memberHashMap.addMember(memberLee);
        
        memberHashMap.showAllMember();
        
        memberHashMap.removeMember(1004); // 회원 아이디(key값)가 1004인 회원 삭제
        memberHashMap.showAllMember();
    }
}
