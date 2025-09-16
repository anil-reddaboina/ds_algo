package liveramp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Traverse the string character by character.
 * If it is an opening bracket ((, [, {), push it onto the stack.
 * If it is a closing bracket (), ], }):
 * Check if the stack is empty → if yes, return False.
 * Otherwise, pop from the stack and ensure the popped element matches the type of closing bracket.
 * If not matching, return False.
 * At the end, if the stack is empty, return True; otherwise, False.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("valid thing " + validParenthesis());
    }

    /**
     * Checks if a string containing just the characters '(', ')', '{', '}', '[' and ']' is valid.
     * Time Complexity: O(n) - We traverse the string once.
     * Space Complexity: O(n) - In the worst case (e.g., "((("), the stack can hold all characters.
     *
     * @param s The input string.
     * @return true if the input string is valid, false otherwise.
     *
     */
    public static boolean isValid(String s) {
        // Use ArrayDeque, the recommended modern implementation for a stack.
        Deque<Character> stack = new ArrayDeque<>();

        //adds the elements to the stack in LIFO order the last added elements will comeout first

        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push the corresponding closing bracket.
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            }
            // If it's a closing bracket
            else {
                // If the stack is empty or the top doesn't match, it's invalid.
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }

        // If the stack is empty at the end, all brackets were matched correctly.
        return stack.isEmpty();
    }


    public static boolean validParenthesis() {
        String s = "()";
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if(ch==')' && top != '(') {
                    return false;
                }
                if (ch ==']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}

