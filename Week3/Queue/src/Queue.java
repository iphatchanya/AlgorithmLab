import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        String[] array = input.split(" ");
        int n = Integer.parseInt(array[0]);
        int m = Integer.parseInt(array[1]);

        StringBuilder[] list = new StringBuilder[10];
        int row;
        for (int i = 0; i < n; i++) {
            String studentName = bufferedReader.readLine();
            row = 0;
            for (int j = 0; j < studentName.length(); j++) {
                row += ((int) studentName.toLowerCase().charAt(j)) - 96;
            }
            row %= m;
            if (list[row] == null) {
                list[row] = new StringBuilder();
                if (row == 0) {
                    list[row].append(studentName);
                }
                else {
                    list[row].append(" " + studentName);
                }
            }
            else {
                list[row].append(" " + studentName);
            }
        }
        for (StringBuilder result : list) {
            if (result != null) {
                System.out.print(result);
            }
        }
    }
}