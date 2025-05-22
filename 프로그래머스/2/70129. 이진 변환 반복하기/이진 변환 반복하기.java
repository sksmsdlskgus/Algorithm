import java.util.*;

class Solution {
    
    int Ocount =0;
    int count = 0;
    
    public int[] solution(String s) {
        List<Integer> result = new ArrayList<>();
        
        while(!s.equals("1")){
            s = binary(s);
        }
        
        result.add(count);
        result.add(Ocount);
        
        return result.stream().mapToInt(i->i).toArray();
    }
    
    private String binary(String s){
        count++; 
        
        int n = s.length();
        int lcount =0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                lcount++;
            }      
        } 
        
        Ocount += n - lcount;
        
        s = "1".repeat(lcount);
        
        int length = s.length(); 
        String lengthBinary = Integer.toBinaryString(length);
        
        return lengthBinary;
        
    }
}