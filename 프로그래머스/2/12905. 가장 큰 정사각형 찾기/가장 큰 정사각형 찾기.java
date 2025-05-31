class Solution{
    public int solution(int [][]board){
        int max = 0;
        int m  = board.length; // y축
        int n = board[0].length; //x축
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            dp[i][0] = board[i][0];
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }
        
        for(int i=0; i<n; i++){
            dp[0][i] = board[0][i];
            if(dp[0][i] > max){
                max = dp[0][i];
            }
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = board[i][j];
                if(dp[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    
                    if(dp[i][j] > max){
                        max = dp[i][j];
                    }
                }
            }
        }

        return max * max;
    }
}