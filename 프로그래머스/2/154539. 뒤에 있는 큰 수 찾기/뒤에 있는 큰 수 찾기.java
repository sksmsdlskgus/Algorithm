import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 나보다 뒤 숫자 중, 나보다 크고, 나랑 가장 가까운 수 = 뒷 큰수
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()] ){
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            
            stack.push(i);
            
        }
        
        return answer;
    }
}