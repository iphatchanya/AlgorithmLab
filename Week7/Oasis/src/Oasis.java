import java.util.Arrays;
import java.util.Scanner;

public class Oasis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int [] gallon = new int[n];

        for (int i = 0; i < n; i++) {
            gallon[i] = sc.nextInt();
        }

        Arrays.sort(gallon);

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (w > gallon[i]) {
                result++;
                w -= gallon[i];
            }
            else if (w == gallon[i]) {
                result++;
                break;
            }
            else {
                break;
            }
        }
        System.out.println(result);
    }
}