import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        StringBuilder answer = new StringBuilder();

        int index = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                index = 0;
            }
            else if (input.charAt(i) == ']') {
                index = answer.length();
            }
            else {
                answer.insert(index, input.charAt(i));
                index++;
            }
        }

        System.out.println(answer.toString());
    }
}