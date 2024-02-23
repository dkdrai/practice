package educative.solution.grokkingcodinginterviewpatterns.subsets;

import java.util.ArrayList;

public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(generateCombinations(2));
    }

    public static ArrayList<String> generateCombinations(int n) {

        // Replace this placeholder return statement with your code

        ArrayList<String> result = new ArrayList<String>();
        util("", result, n, n);
        return result;
    }

    public static void util(String s, ArrayList<String> result, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(s);
            return;
        }
        if (open > 0) {
            util(s + "(", result, open - 1, close);
        }
        if (close > open) {
            util(s + ")", result, open, close - 1);
        }
    }
}