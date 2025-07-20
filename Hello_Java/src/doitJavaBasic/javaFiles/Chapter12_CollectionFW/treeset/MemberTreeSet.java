package Chapter12_CollectionFW.treeset;

import Chapter12_CollectionFW.collection.Member;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
    private TreeSet<Member> treeSet;

    public MemberTreeSet() {
        treeSet = new TreeSet<Member>();
    }



    public void addMember(Member member) { // 회원 추가 메서드
        treeSet.add(member);
    }

    public boolean removeMember(int memberID) { // 회원 삭제 메서드
        Iterator<Member> ir = treeSet.iterator();

        while (ir.hasNext()) {
            Member member = ir.next();
            int tempID = member.getMemberID();
            if (tempID == memberID) {
                treeSet.remove(member);
                return true;
            }
        }
        System.out.println(memberID + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : treeSet) {
            System.out.println(member);
        }
        System.out.println();
    }
}
