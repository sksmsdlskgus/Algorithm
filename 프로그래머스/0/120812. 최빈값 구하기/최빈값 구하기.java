import java.util.*;

class Solution {
    public int solution(int[] array) {
 
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        

        int maxFrequency = 0;
        int mode = -1;
        boolean isUnique = true;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if (value > maxFrequency) {
                maxFrequency = value;
                mode = key;
                isUnique = true; 
            } else if (value == maxFrequency) {
                isUnique = false; 
            }
        }

        return isUnique ? mode : -1;
    }
}
