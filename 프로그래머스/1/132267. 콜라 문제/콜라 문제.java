class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int exchange = n / a;    
            int get = exchange * b;  

            answer += get; 
            n = get + (n % a);           
        }
        
        return answer;
    }
}