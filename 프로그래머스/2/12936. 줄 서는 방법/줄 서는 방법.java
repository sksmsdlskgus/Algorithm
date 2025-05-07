import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        // n = 사람 수 , k = 방법들 중 k번째 배열을 return
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        
        for(int i=1; i<=n; i++){ // n까지 다 넣기
            numbers.add(i);
        }
        
        long fact = calculateFactorial(n);
            
        k--; 
        
        for(int i=0; i<n; i++){
            int index = (int)(k/fact); // 첫번째 숫자가 어떤 숫자가 올지
            answer[i] = numbers.get(index);
            numbers.remove(index);
            
            if(n-1-i >0){ // 그다음 숫자를 위해 경우의 수 줄이기
                k %= fact;
                fact /= (n-1-i);
            }
            
        }
        
        return answer;
    }
    
    private long calculateFactorial(int num){
        long fact =1;
        
        for(long i=1; i<num; i++){
            fact*= i;
        }
        
        return fact;
    }
}