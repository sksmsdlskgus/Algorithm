class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String xString = Integer.toString(x);
        
        int sum =0;
        for(int i=0; i<xString.length(); i++){
            char c = xString.charAt(i);
            int cInt = Character.getNumericValue(c);
            sum += cInt;
           
            if(x%sum ==0){
                answer = true;
            }else{
                answer = false;
            }
        }
        return answer;
    }
}