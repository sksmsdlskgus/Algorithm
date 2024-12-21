class Solution { 
    boolean solution(String s) {
        boolean answer = true;
        int countTrue = 0;
        int countFalse = 0;
    
        for(int i=0; i<s.length(); i++){
            char result = s.charAt(i);
            
          if(result=='('){
              countTrue++;
          }else if(result==')') {
              countFalse++;
          }
    
        if (countFalse > countTrue) {
                return false;
        }
    }
        
        answer = (countTrue == countFalse);

        System.out.println(answer);
        return answer;
    }
}