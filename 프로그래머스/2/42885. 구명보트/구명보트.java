import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람들을 무게순으로 정렬하여 처리
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        
        int start = 0; // 가장 가벼운사람 
        int end = people.length - 1; // 가장 무거운사람
        int result = 0;
        
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;  
            }
            end--;  
            result++; 
        }

        return result;
    }
}
