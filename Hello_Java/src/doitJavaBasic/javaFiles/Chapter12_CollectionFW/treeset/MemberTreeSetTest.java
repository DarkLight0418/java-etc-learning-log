package Chapter12_CollectionFW.treeset;

import Chapter12_CollectionFW.collection.Member;

public class MemberTreeSetTest {
    public static void main(String[] args) {
        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member memberPark = new Member(1003, "박지성");
        Member memberSon = new Member(1001, "손흥민");
        Member memberSeol = new Member(1002, "설영우");

        memberTreeSet.addMember(memberPark);
        memberTreeSet.addMember(memberSon);
        memberTreeSet.addMember(memberSeol);
        memberTreeSet.showAllMember();

        Member memberHong = new Member(1003, "홍정호"); // 아이디 중복 회원 추가
        memberTreeSet.addMember(memberHong);
        memberTreeSet.showAllMember();

    }
}
