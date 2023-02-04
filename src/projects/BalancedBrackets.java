package projects;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean balancedBrackets(String input) {

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < input.length(); i += 1) {

            if (bracketPairs.containsValue(input.charAt(i))) {
                stack.push(input.charAt(i));
            }
            else if (bracketPairs.containsKey(input.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character lastBracket = stack.pop();
                if (!lastBracket.equals(bracketPairs.get(input.charAt(i)))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
