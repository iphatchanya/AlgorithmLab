import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SSS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sequence.add(scanner.nextInt());
        }

        int threshold = scanner.nextInt();
        int result = 0;
        Collections.sort(sequence);

        for (int i = sequence.size()-1; i >= 0; i--) {
            if (threshold - sequence.get(i) >= 0) {
                threshold -= sequence.get(i);
                result++;
            }
        }

        if (threshold != 0) {
            System.out.println("No");
        }
        else {
            System.out.println(result);
        }

    }
}
