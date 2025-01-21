import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // priorities = 프로세스의 중요도 가장 큰 숫자부터 같으면 해당 다음부터 ㄱ
        // location = 프로세스의 위치 0 부터
        // 해당 프로세스가 몇 번째로 실행되는지 return
         
        int printOrder =0;
        
        Queue<int[]> queue = new LinkedList<>();
       
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i}); // 중요도와 인덱스를 배열로 저장
        }
 
        while (!queue.isEmpty()) {
            int[] first = queue.poll(); 
            boolean Priority = false;

            // 중요도 확인
            for (int[] item : queue) {
                if (item[0] > first[0]) { // 더 높은 중요도 발견
                    Priority = true;
                    break;
                }
            }

            if (Priority) {
                
                queue.offer(first);
                
            } else {
                
                printOrder++;
                
                if (first[1] == location) {
                    
                    return printOrder;
                }
            }
        }

        return -1;
    }
}