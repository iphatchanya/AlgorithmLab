import java.util.Scanner;

public class TheTrickyModulus {

    public static void main(String[] args) {
        long x, y;

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int n = scanner.nextInt();

        try {
            x = Long.valueOf(a.substring(a.length() - n));
        } catch (StringIndexOutOfBoundsException e) {
            x = Long.valueOf(a);
        }
        try {
            y = Long.valueOf(b.substring(b.length() - n));
        } catch (StringIndexOutOfBoundsException e) {
            y = Long.valueOf(b);
        }

        System.out.println(String.valueOf(x*y).substring(String.valueOf(x*y).length() - n));
    }
}