import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Army {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[] arrayn = new int[n];
        String inputmDamage = bufferedReader.readLine();
        String[] arraymDamage = inputmDamage.split(" ");

        for (int i = 0; i < n; i++) {
            arrayn[i] = Integer.parseInt(arraymDamage[i]);
        }

        int[] answer = countingSort(arrayn);
        for (int i = 0; i < m; i++) {
            System.out.println(upperBound(answer,0,n,Integer.parseInt(bufferedReader.readLine())));
        }
    }

    public static int[] countingSort(int[] array) {
        int[] sort = new int[array.length];
        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            else if (array[i] > max) {
                max = array[i];
            }
        }

        int[] count = new int[max-min+1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]-min]++;
        }
        count[0]--;

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i = array.length-1; i >= 0; i--) {
            sort[count[array[i]-min]--] = array[i];
        }
        return sort;
    }

    public static int upperBound(int[] array, int low, int high, int key) {
        low -= 1;
        while(low+1 != high) {
            int sum = (low+high)>>>1;
            if (array[sum] > key) {
                high = sum;
            }
            else {
                low = sum;
            }
        }
        return low+1;
    }

}
