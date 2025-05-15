class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
                       
        while(n > 0){
            int rule = n%3;
            n = n/3;
            
            if(rule == 0){
                rule = 4;
                n -=1;
            }
            
            sb.append(rule);
        }
                
        return sb.reverse().toString();
    }
}