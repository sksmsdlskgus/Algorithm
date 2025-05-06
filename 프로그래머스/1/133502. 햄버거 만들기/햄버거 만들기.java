import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        // 빵- 야채- 고기- 빵 -> 순서로만 햄버거 포장 
        // 1=빵, 2=야채, 3=고기 -> 1,2,3,1 이 부분 포함
        
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i:ingredient){
            stack.push(i);
            
            if(stack.size() >= 4){
                int size = stack.size();
                if(stack.get(size-4) ==1 &&
                  stack.get(size-3) ==2 &&
                  stack.get(size-2) ==3 &&
                  stack.get(size-1) ==1){
                    
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    
                    count++;
                }
            }
            
            
            
        }
        
        return count;
    }
}