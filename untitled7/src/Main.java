import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = readInput();
        int result;
        d(n) = (n - 1) * (d(n - 1) + d(n - 2) )
        result = n;
        System.out.println(result);
    }

    public static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}