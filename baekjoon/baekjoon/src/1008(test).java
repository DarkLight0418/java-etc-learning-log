import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner div = new Scanner(System.in);

        int a = div.nextInt();
        int b = div.nextInt();

        double c = a / b;

        System.out.println("%d", c);
    }
}