import java.util.*;

class Solution {
    int solution(int[][] land) {
        // y축 N , x축 4
        // 각 행이 4열중 하나만 밟아야함 
        // 단, 그 열이 다 달라야함 1,2,3,4를 포함해야함. 중복 X
        // 밟은 땅의 값을 sum해서 return
        
        int result = 0;
        int m = land.length; // y축 길이
        int[][] dp = new int[m][4];
        
        for(int i=0; i<4; i++){ // 2차원 배열 첫 행만 복사
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<m; i++){ // 다음 행부터 시작하면서 dp 전이 시킴
            for(int j=0; j<4; j++){
                int max = 0; 
                
                for(int k=0; k<4; k++){
                    if (k != j) { // 동일 열을 밟을시는 안됨
                        max = Math.max(max, dp[i - 1][k]); // 그러고 각 행에서 최댓값 ㅊ처리 
                    }
                }
                
                dp[i][j] = max + land[i][j]; // 최댓값을 저장
            }
        }
        
        for(int i=0; i<4; i++){
            result = Math.max(result,dp[m-1][i]); // 마지막 행에서 각열중에서 최댓갑을 반환
        }

        return result;
    }
}