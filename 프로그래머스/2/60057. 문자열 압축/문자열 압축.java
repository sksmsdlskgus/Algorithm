import java.util.*;

class Solution {
    public int solution(String s) {
        int slength = s.length();
        
        for(int i=1; i<=s.length()/2; i++){
            int count =1;
            String result = ""; // 결과
            String pre = s.substring(0,i); // 자르기
            
            for(int j =i; j<s.length(); j+=i){
                String sub;
                
                if(j+i>s.length()){
                    sub = s.substring(j);
                }else {
                    sub = s.substring(j,j+i);
                }
                
                if(pre.equals(sub)){
                    count++;
                }else{
                    result += (count>1 ? count : "") + pre;
                    pre=sub;
                    count =1; // 초기화
                }
                
            }
            result += (count>1 ? count : "") + pre;
            
            slength = Math.min(slength,result.length()); // 최소값
        }
        
        return slength;
    }
}