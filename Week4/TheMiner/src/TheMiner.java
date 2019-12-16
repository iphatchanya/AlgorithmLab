import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMiner {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] array = input.split(" ");

        double a, b, c, d, all, change, found;
        int e;
        a = Double.parseDouble(array[0]);
        b = Double.parseDouble(array[1]);
        c = Double.parseDouble(bufferedReader.readLine());
        d = Double.parseDouble(bufferedReader.readLine());
        e = Integer.parseInt(bufferedReader.readLine());
        all = a+b;
        change = (a/(a+b)) * 100;

        for (int i = 1; i < e; i++) {
            all = ((all*c)/100) + all;
            change = change * (1+d/100);
            if (change > 100) {
                change = 100;
            }
            found = (change*all)/100;
            a += found;
            b += all - found;
        }
        System.out.printf("%.2f %.2f", a, b);
    }

}
