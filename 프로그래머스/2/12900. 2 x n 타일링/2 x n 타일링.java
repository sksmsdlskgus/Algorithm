class Solution {
    public int solution(int n) {
        // 가로2 세로1인 직사각형 모양
        // 가로n 세로2로 채우고 싶은데 
        // 가로로 배치하는경우, 세로로 배치하는경우 총 2가지 방법이 존재
        // 방법의 수를 return해라
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        
        return (int)dp[n];
    }
}