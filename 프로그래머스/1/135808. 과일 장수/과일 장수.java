import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score); 
        
        int n = score.length;
        int profit = 0;

        for (int i = n - m; i >= 0; i -= m) {
            int min = score[i]; 
            profit += min * m;
        }

        return profit;
    }
}
