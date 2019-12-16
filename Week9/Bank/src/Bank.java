import java.util.Arrays;
import java.util.Scanner;


public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = scanner.nextInt();
        }
        Arrays.sort(c);

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            System.out.println(finding(x, c));
        }

    }
    private static int finding(int n, int[]c){
        int[] cx = new int[n+1];
        cx[0] = 1;
        for(int i=0; i < c.length; i++) {
            for(int j=c[i]; j <= n; j++) {
                cx[j] += cx[j - c[i]];
            }
        }

        return cx[n];
    }
}