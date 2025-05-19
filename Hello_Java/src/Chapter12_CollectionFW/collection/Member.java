package Chapter12_CollectionFW.collection;

import java.util.Comparator;
import java.util.Objects;
// import singleton.Company;

public class Member implements Comparable<Member> {
    private int memberID;  // 회원 아이디
    private String memberName;  // 회원 이름

    public Member(int memberID, String memberName) {
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
        if (obj instanceof Member) {
            Member member = (Member) obj;
            if (this.memberID == member.memberID)  // 매개변수로 받은 회원 아이디가 자신의 회원 아이디와 같다면 true 반환
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public int compareTo(Member member) {
        return(this.memberID-member.memberID);
    }
}