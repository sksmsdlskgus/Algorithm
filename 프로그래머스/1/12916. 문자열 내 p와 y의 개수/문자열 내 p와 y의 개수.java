class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        
        int p_count = 0;
        int y_count = 0;
        
        for(int i=0; i<s.length(); i++){         
            for(char c : s.toCharArray()){                
                if(c == 'p'){
                    p_count++;
                }else if(c == 'y'){
                    y_count++;
                }
            }
            
        }
        
        if(p_count != y_count){
            answer = false;
        }

        return answer;
    }
}