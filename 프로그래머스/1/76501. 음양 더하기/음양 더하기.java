class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        
        int index = 0;
        for(boolean b : signs){
            if(b == false){
                sum -= absolutes[index];
            }else{
                sum += absolutes[index];
            }
            
            index++;
        }
        
        return sum;
    }
}