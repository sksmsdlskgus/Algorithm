import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;
        int[] extended = new int[n * 2];

        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n]; // 원형 배열 담기 
        }

        for (int length = 1; length <= n; length++) {
            int sum = 0;

            for (int i = 0; i < length; i++) {
                sum += extended[i];
            }
            
            set.add(sum);

            for (int i = length; i < n + length - 1; i++) {
                sum += extended[i] - extended[i - length];
                set.add(sum);
            }
        }

        return set.size();
    }
}
