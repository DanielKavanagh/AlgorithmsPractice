package StackQueueProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    Stack<String> bracketStack = new Stack<>();
    Map<String, String> bracketMap = new HashMap<>();

    public ValidParentheses() {
        this.bracketMap.put("{", "}");
        this.bracketMap.put("[", "]");
        this.bracketMap.put("(", ")");
    }


    public boolean isValid(String input) {
        for (char i : input.toCharArray()) {
            if (bracketMap.containsKey(String.valueOf(i))) {
                bracketStack.push(String.valueOf(i));
            } else {
                if (bracketStack.empty()) {
                    return false;
                }

                if (!bracketMap.get(bracketStack.pop()).equals(String.valueOf(i))) {
                    return false;
                }
            }
        }

        return bracketStack.empty();
    }
}
