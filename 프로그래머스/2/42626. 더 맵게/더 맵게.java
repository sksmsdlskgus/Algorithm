import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 스코빌 지수 k이상으로 만들기 
        // 가장 낮은 두개의 음식 
        // 가장 안매운음식 + (두번째로 *2)
        // 모두가 k 이상이 될때까지 반복
        // 최소 횟수를 return 해라 -> 없을 경우에는 -1
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i:scoville){
            pq.offer(i);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int one = pq.poll();
            int two = pq.poll();
            
            int mixed = one +(two*2);
            pq.offer(mixed);
            count++;    
        }
        
        return pq.peek() >= K ? count : -1;
    }
}