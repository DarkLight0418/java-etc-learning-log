package Chapter12_CollectionFW.hashset;

import Chapter12_CollectionFW.collection.Member;

public class MemberHashSetTest {
    public static void main(String[] args) {
        MemberHashSet memberHashSet = new MemberHashSet();

        Member memberLee = new Member(1001, "이승우");
        Member memberSon = new Member(1002, "손민국");
        Member memberPark = new Member(1003, "박지성");

        memberHashSet.addMember(memberLee);
        memberHashSet.addMember(memberSon);
        memberHashSet.addMember(memberPark);
        memberHashSet.showAllMember();

        Member memberHong = new Member(1003, "홍정호");  // 아이디가 중복된 회원 추가
        memberHashSet.addMember(memberHong);
        memberHashSet.showAllMember();
    }
}
