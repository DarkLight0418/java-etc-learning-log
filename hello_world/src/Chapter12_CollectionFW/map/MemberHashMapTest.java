package Chapter12_CollectionFW.map;

import Chapter12_CollectionFW.collection.Member;

public class MemberHashMapTest {
    public static void main(String[] args) {
        MemberHashMap memberHashMap = new MemberHashMap();
        
        Member memberLee = new Member(1001, "이상민");
        Member memberPark = new Member(1002, "박지성");
        Member memberHong = new Member(1003, "홍정호");
        Member memberJo = new Member(1004, "조용국");
        
        memberHashMap.addMember(memberLee);
        memberHashMap.addMember(memberPark);
        memberHashMap.addMember(memberHong);
        memberHashMap.addMember(memberJo);
        
        memberHashMap.showAllMember();
        memberHashMap.removeMember(1004);  // 회원 아이디(key값)가 1004인 회원 삭제
        memberHashMap.showAllMember();
    }
}
