import java.util.Stack;

/**
 * Created by Sorcerer on 2016/1/10 0010.
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 */
public class _20_Valid_Parentheses {
    public static void main(String[] args) {
        isValid("[()]()");
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && isReverse(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean isReverse(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }
}
