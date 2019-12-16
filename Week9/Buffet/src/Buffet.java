import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Buffet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input[] = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        buf[] nn = new buf[n];
        for (int i = 0; i < n; i++) {
            String[] input2 = bufferedReader.readLine().split(" ");
            int p = Integer.parseInt(input2[0]);
            int w = Integer.parseInt(input2[1]);
            nn[i] = new buf(p, w);
        }

        int[] cc = new int [m];
        int maxs = 0;
        for (int i = 0; i < m; i++) {
            int c = Integer.parseInt(bufferedReader.readLine());
            cc[i] = c;
            maxs = Math.max(maxs, c);
        }

        int[] result = new int[maxs+1];
        for (int i = 0; i <= maxs; i++) {
            for (int j = 0; j < n; j++) {
                if(nn[j].w <= i) {
                    result[i] = Math.max(result[i], result[i-nn[j].w]+nn[j].p);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(result[cc[i]]);
        }

    }

    static class buf {
        int p, w;
        buf(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }
}
