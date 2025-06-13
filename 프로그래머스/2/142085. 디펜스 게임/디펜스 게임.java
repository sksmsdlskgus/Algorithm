import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 병사 n명 , 무적권은 최대 k번, 매 라운드 마다 enemy 길이의 적의 수 
        // enemy 마리의 적이 등장, enemy명 만큼 소모하여 enemy마리의 적을 막을 수 있음
        // 남은 병사의 수 n보다 enemy길이가 더 크면 게임이 종료됨
        // 무적권 스킬 -> 병사의 소모없이 한 라운드의 공격을 막을 수 있음
        // 몇 라운드까지 막을 수 있는지 return -> 모두 막을 수 있는경우 -> enemy길이를 return
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        for (; i < enemy.length; i++) {
            maxHeap.add(enemy[i]); 
            n -= enemy[i]; 

            if (n < 0) {
                if (k > 0) {
                    n += maxHeap.poll(); 
                    k--;
                    
                }else {
                    break; 
                }
            }
        }
        return i; 
    }
}