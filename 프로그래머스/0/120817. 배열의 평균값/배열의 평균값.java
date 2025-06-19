class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double len = numbers.length;
        
        for(int i=0; i<len; i++){
            answer += numbers[i];
        }
        
        return answer/len;
    }
}