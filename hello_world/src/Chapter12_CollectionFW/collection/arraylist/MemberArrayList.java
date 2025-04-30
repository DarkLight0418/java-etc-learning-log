package Chapter12_CollectionFW.collection.arraylist;

import java.util.ArrayList;
import Chapter12_CollectionFW.collection.Member;

public class MemberArrayList {
    private ArrayList<Member> arrayList;  // ArrayList 선언

    public MemberArrayList() {
        arrayList = new ArrayList<Member>();  // Member형으로 선언한 ArrayList 생성
    }

    public void addMember(Member member) {
        arrayList.add(member);   // ArrayList에 회원을 추가하는 메서드
    }

    public boolean removeMember(int memberID) {
        for (int i = 0; i < arrayList.size(); i++) {
            Member member = arrayList.get(i);  // get() 메서드로 회원을 순차적으로 가져옴
            int tempID = member.getMemberID();
            if (tempID == memberID) {  //  회원 아이디가 매개변수랑 일치하면
                arrayList.remove(i);  // 해당 회원 삭제
                return true;
            }
        }
        System.out.println(memberID + "가 존재하지 않습니다.");   // 반복문이 끝날 때까지 해당 아이디를 찾지 못한 경우
        return false;

    }
    // 해당 아이디를 가진 회원을 ArrayList에서 찾아 제거

    public void showAllMember() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println( );
    }

    // 전체 회원을 출력하는 메서드
}
