package projects;

public class balancedParens {

    public static boolean balancedParentheses(String input) {
        int numParens = 0;
        for (int i = 0; i < input.length(); i += 1) {
            if (input.charAt(i) == '(') {
                numParens += 1;
            }
            else if (input.charAt(i) == ')') {
                numParens -= 1;
            }

            if (numParens < 0) {
                return false;
            }
        }

        return numParens == 0;
    }

}
