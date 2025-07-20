package doitJavaBasic.javaFiles.chapter6_class2.no2_cooperation;

public class TakeTrans {
    public static void main(String[] args) {
        Student studentKim = new Student("김민우", 6000);
        Student studentLee = new Student("이진혁", 12000);
    
        Bus bus143 = new Bus(143);  // 노선 번호가 143번인 버스 생성
        studentKim.takeBus(bus143);  //  민우가 143번 버스를 탐
        studentKim.showInfo();  // 민우 정보 출력
        bus143.showInfo();  // 버스 정보 출력
        
        Subway suinBundangLine = new Subway("수인분당선");  // 노선 이름이 '수인분당선'인 전철 생성
        studentLee.takeSubway(suinBundangLine);  // 진혁이가 수인분당선을 탐
        studentLee.showInfo();  // 진혁쓰 정보 출력
        suinBundangLine.showInfo(); // 전철 정보 출력
    }
}
