import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x,term0, term1, next;
        x = scanner.nextInt();
        term0 = 0;
        term1 = 1;
        next = 0;

        if (x >= 0 && x <= 50) {
            for (long i = 1; i <= x; i++) {
                term0 = term1;
                term1 = next;
                next = term0 + term1;
            }
            System.out.println(next);
        }
    }
}
