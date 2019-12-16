import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Character> stack = new Stack<Character>();
        String input = scanner.next();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(input.charAt(i));
            }
            else if (!stack.empty() && (input.charAt(i) == ')' && stack.peek() == '(' || input.charAt(i) == '}' && stack.peek() == '{' || input.charAt(i) == ']' && stack.peek() == '[') ) {
                stack.pop();
            }
            else {
                stack.push(input.charAt(i));
            }
        }
        if (stack.empty()) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
