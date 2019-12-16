import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Workers {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int [] produce = new int[n];
        String [] str = input.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            produce[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(produce);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += produce[i];
            i++;
        }

        System.out.println(sum);
    }
}
