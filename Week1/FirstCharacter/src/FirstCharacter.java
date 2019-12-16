import java.util.HashMap;
import java.util.Scanner;

public class FirstCharacter {
    public static void main(String[] args) {
        char min = 0;
        int temp = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            if (hashmap.get(input.charAt(i)) == null) {
                hashmap.put(input.charAt(i), 1);
            }
            else {
                hashmap.put(input.charAt(i), (hashmap.get(input.charAt(i))+1));
            }
        }

        for (Character c : hashmap.keySet()) {
            if (temp == 0) {
                min = c;
                temp = hashmap.get(c);
            } else {
                if (temp > hashmap.get(c)) {
                    min = c;
                    temp = hashmap.get(c);
                }
            }
        }

        System.out.println(min);
    }
}
