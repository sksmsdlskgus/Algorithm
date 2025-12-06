import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> result = new ArrayList<>();

        for (String t : targets) {
            int total = 0;     
            boolean possible = true; 

            for (char c : t.toCharArray()) {
                int minIndex = Integer.MAX_VALUE; 

                for (String k : keymap) {
                    int idx = k.indexOf(c);  

                    if (idx != -1) {       
                        minIndex = Math.min(minIndex, idx + 1);
                    }
                }

                if (minIndex == Integer.MAX_VALUE) {
                    possible = false;
                    break;
                }

                total += minIndex; 
            }

            result.add(possible ? total : -1);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
