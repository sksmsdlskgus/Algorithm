class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int service = 0;
        
        service = n/10;
        
        answer = (n*12000)+((k-service)*2000);
        return answer;
    }
}