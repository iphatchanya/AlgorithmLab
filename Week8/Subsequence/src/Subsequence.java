import java.util.ArrayList;
import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            sequence.add(scanner.nextInt());
        }

        int threshold = scanner.nextInt();
        int check = threshold, set = 0, result = 0;

        for (int i = 0; i < sequence.size(); i++) {
            if (check > 0) {
                check -= sequence.get(i);
                set++;
            }
            else {
                check = threshold;
                if (result == 0 || set < result) {
                    result = set;
                }
                set = 0;
                i -= set;
            }
        }

        if (result == 0) {
            System.out.println("No");
        }
        else {
            System.out.println(result);
        }
    }


}
