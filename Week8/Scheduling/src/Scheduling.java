import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Scheduling {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int s, e, max = 0, preEnd = 0, done = 0;
        String array[];
        int[][] homework = new int[1000][2];
        int[] order = new int[1000];

        for (int i = 0; i < n; i++) {
            array = bufferedReader.readLine().split(" ");
            s = Integer.parseInt(array[0]);
            e = Integer.parseInt(array[1]);

            if(homework[e][0] == 0 || s > homework[e][0] && homework[e][0] != 0) {
                if(e > max && homework[e][0] == 0) {
                    max = e;
                }
                homework[e][0] = s;
                homework[e][1] = i + 1;
            }
        }

        for (int i = 0; i <= max; i++) {
            if (homework[i][0] > 0) {
                if (homework[i][0] >= preEnd || preEnd == 0) {
                    order[done] = homework[i][1];
                    preEnd = i;
                    done++;
                }
            }
        }
        System.out.println(done);

        for (int i = 0; i < done; i++) {
            System.out.print(order[i] + " ");
        }
    }
}