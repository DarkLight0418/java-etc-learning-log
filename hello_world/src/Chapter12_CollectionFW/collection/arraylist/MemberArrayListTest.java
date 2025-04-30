package Chapter12_CollectionFW.collection.arraylist;

import Chapter12_CollectionFW.collection.Member;

public class MemberArrayListTest {
    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();
        
        Member memberLee = new Member(1001, "이재성");
        Member memberSon = new Member(1002, "손흥민");
        Member memberPark = new Member(1003, "박지성");
        Member memberHong = new Member(1004, "홍정호");
        // 새로운 회원 인스턴스 생성

        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberSon);
        memberArrayList.addMember(memberPark);
        memberArrayList.addMember(memberHong);

        // ArrayList에 회원 추가

        memberArrayList.showAllMember();  // 전체 회원 출력
    
        memberArrayList.removeMember(memberHong.getMemberID());  // 홍정호 회원 삭제
        memberArrayList.showAllMember();;  // 홍정호 회원 삭제 후 다시 전체 회원 출력
    }
}
