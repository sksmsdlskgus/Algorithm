class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // m = x축 ,n = y축
        // 오른쪽(x축 ++) 과 아래쪽(y축 ++) 으로만 움직여 집 
        // -> 학교 최단경로 개수를 val로 나눈 수 return
        // 물에 잠긴 지역은 0~10개 , m과 n이 모두 1일 경우 -> 제한
        
        long[][] dp = new long[n][m];
        boolean[][] visited = new boolean[n][m];
        int val = 1000000007;
        
        dp[0][0] = 1;
        
        for (int[] puddle : puddles) {
            int x = puddle[0] - 1;
            int y = puddle[1] - 1;
            if (x >= 0 && x < m && y >= 0 && y < n) {
                visited[y][x] = true;
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i>0) dp[i][j] += dp[i-1][j];   
                if(j>0)dp[i][j] += dp[i][j-1];
                dp[i][j] %= val;
            }
        }
        
        
        return (int) dp[n-1][m-1];
    }
}