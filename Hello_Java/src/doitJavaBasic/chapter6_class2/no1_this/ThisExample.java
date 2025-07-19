package chapter6_class2.no1_this;

class BirthDay {
    int day;
    int month;
    int year;

    public void setYear(int year) {  // 출생년도 지정 메서드
        this.year = year;  // bDay.year = year; 와 같음
    }

    public void printThis() {  // this 출력 메서드
        System.out.println(this);   // sout(bDay);
    }
}

public class ThisExample {
    public static void main(String[] args) {
        BirthDay bDay = new BirthDay();
        bDay.setYear(2000);
        System.out.println(bDay);
        bDay.printThis();
    }
}
