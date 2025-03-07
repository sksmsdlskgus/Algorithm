import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int removed = 0;

        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && removed < k) {
                stack.pop();
                removed++;
            }
            stack.push(number.charAt(i));
        }

        while (removed < k) {
            stack.pop();
            removed++;
        }


        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}
