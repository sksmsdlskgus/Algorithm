import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 가장 문제를 많이 맞힌 사람이 누구인지 배열에 담아 return
        // 1번 -> 12345 반복
        // 2번 -> 212324225 반복
        // 3번 -> 3311224455 반복
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = {0, 0, 0};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                scores[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                scores[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);  
            }
        }
        

        return  result.stream().mapToInt(i -> i).toArray();
    }
}
