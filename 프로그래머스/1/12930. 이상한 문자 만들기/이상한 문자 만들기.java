class Solution {
    public String solution(String s) {
        // 짝수번째는 대문자 
        // 홀수번째는 소문자

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                sb.append(' ');
                idx =0;
            }else{
                if(idx%2 == 0){
                    sb.append(Character.toUpperCase(c));
                }else{
                    sb.append(Character.toLowerCase(c));
                }
                
                idx++;
            }
            
        }
        
        return sb.toString();
    }
}