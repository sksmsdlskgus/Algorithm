import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0]; 
        
        int[] result = new int[n];
        int index = 0; 
        
        result[index++] = arr[0]; 
        
        for (int i = 1; i < n; i++) {
            // 이전 값과 다를 때만 추가
            if (arr[i] != arr[i - 1]) {
                result[index++] = arr[i];
            }
        }
        
        return Arrays.copyOf(result, index);
    }
}
