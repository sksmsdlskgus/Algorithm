class Solution {
    public String solution(String s) {
        String answer = "";
        
        int n = s.length();
        
        for(int i=0; i<s.length(); i++){
            
            if(n%2==0){
                int start = n/2-1;
                int end = n/2+1;
                
                answer = s.substring(start, end);
                
            }else {
                int start = n/2;
                int end = n/2+1;
                
                answer = s.substring(start, end);
                
            }
            
        }
        
        
        return answer;
    }
}