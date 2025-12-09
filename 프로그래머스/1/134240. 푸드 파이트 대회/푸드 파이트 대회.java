class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            int dish = food[i];
        
            int num = dish/2;
                
            for(int j=1; j<=num; j++){
                answer.append(Integer.toString(i));
            }
                
            }
        
        return answer.toString() + "0" + answer.reverse();
    }
}