class Solution {
    public int solution(int n) {
        // 가로2 세로1
        // 가로n 세로3
        // 출발일때 경우의 수 1
        // 가로는 짝수일때만 성립이 가능하다.
        // 홀수면은 필요없음
        
        long[] dp = new long[n+1];
        int val = 1000000007;
        dp[0] = 1;
        dp[2] = 3;
         
        for(int i=4; i<=n; i+=2){
             dp[i] = dp[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += dp[i - j] * 2;
            }
            dp[i]%=val;
        }
        
        return (int)dp[n];
    }
}