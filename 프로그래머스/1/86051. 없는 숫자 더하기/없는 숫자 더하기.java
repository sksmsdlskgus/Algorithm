class Solution {
    public int solution(int[] numbers) {
        int total = 0;
        int sum = 0;
        

        for (int i = 0; i <= 9; i++) {
            sum += i; 
        }
        

        for (int num : numbers) {
            total += num;
        }
        
        return sum - total ;  
    }
}
