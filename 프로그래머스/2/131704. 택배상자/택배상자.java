import java.util.*;

class Solution {
    public int solution(int[] order) {
        int count = 0;
        int index = 0;
        int box = 1;
        int len = order.length;
        
        Stack<Integer> stack = new Stack<>();
        
        while(box <= len){
            if(box == order[index]){
                count++;
                index++;
            }else if(!stack.isEmpty()&&stack.peek()==order[index]){
                count++;
                stack.pop();
                index++;
                continue;
            }else {
                stack.push(box);
            }
            
            box++;
        }
        
        while(!stack.isEmpty() && stack.peek()==order[index]){
            count++;
            stack.pop();
            index++;
        }
        
        return count;
    }
}