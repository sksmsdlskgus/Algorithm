import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    char[] chars = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        makeWords("", 0);
        return dictionary.indexOf(word) + 1;
    }

    private void makeWords(String current, int depth) {
        if (depth > 5) return;
        if (!current.isEmpty()) dictionary.add(current);

        for (char c : chars) {
            makeWords(current + c, depth + 1);
        }
    }
}
