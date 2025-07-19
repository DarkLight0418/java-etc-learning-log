import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();

        while (true) {
            System.out.println("\n1. 추가 | 2. 목록 | 3. 검색 | 4. 수정 | 5. 삭제 | 0. 종료");
            System.out.print("선택 > ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("이름 : ");
                    String name = sc.nextLine();
                    System.out.print("전화번호 : ");
                    String phone = sc.nextLine();
                    System.out.print("이메일 : ");
                    String email = sc.nextLine();


                    pb.addContact(new Contact(name, phone, email));
                }
                case "2" -> pb.listContacts();
                case "3" -> {
                    System.out.print("검색할 이름 : ");
                    Contact c = pb.searchContact(sc.nextLine());
                    System.out.println(c != null ? c : "찾을 수 없습니다.");
                }
                case "4" -> {
                    System.out.print("수정할 이름 : ");
                    String name = sc.nextLine();
                    System.out.print("새 전화번호 : ");
                    String phone = sc.nextLine();
                    System.out.print("새 이메일 : ");
                    String email = sc.nextLine();

                    pb.updateContact(name, new Contact(name, phone, email));
                }
                case "5" -> {
                    System.out.print("삭제할 이름: ");
                    pb.removeContact(sc.nextLine());
                }

                case "0" -> {
                    System.out.println("프로그램 종료");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}