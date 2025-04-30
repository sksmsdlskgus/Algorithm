class Solution {
    public int[] solution(int[] num_list) {        
        int limit = num_list.length;
        int[] reversed = new int[limit];  
        
        for(int i = 0; i < limit; i++){
            reversed[i] = num_list[limit - 1 - i];
        }
            
        return reversed;
    }
}