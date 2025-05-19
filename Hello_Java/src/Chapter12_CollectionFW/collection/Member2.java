package Chapter12_CollectionFW.collection;

import java.util.Comparator;

public class Member2 implements Comparator<Member2> {
    private int memberID;
    private String memberName;

    public Member2(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return memberName + " 회원님의 아이디는 " + memberID + "입니다.";
    }

    @Override
    public int hashCode() {
        return memberID; // hashCode() 메서드가 회원 아이디를 반환하도록 재정의
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member2) {
            Member2 member = (Member2)obj;
            if (this.memberID == member.memberID) {
                return true;
            }
            else
                return false;
        }
        return false;
    }

    @Override
    public int compare(Member2 mem1, Member2 mem2) {  // compare 메서드 재정의, 전달받은 두 매개변수를 비교
        return mem1.getMemberID() - mem2.getMemberID();
    }
}