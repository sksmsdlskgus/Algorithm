import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        List<Character> available = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            if (skip.indexOf(c) == -1) {
                available.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int currentIndex = available.indexOf(ch);
            int newIndex = (currentIndex + index) % available.size(); 
            sb.append(available.get(newIndex));
        }

        return sb.toString();
    }
}
