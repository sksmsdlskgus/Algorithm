class Solution {
    public long solution(int n) {
        // 한번에 1칸, 2칸 뜀박질 가능
        // 그 방법의 수를 구해, 1234567을 나눈 나머지를 리턴해라.
        // 1이랑 2를 더해서 n으로 만들기
        long answer = 0;
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        
        
        return dp[n];
    }
}