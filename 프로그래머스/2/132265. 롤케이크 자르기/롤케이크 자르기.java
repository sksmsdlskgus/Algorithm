import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 공평한 것 = 토핑의 가짓수가 같으면.
        // 토핑은 총 4가지.
        // 공평하게 자르는 방법의 수를 return 해라.
        // 자를수있는 경우의 수는 총 topping.length -1 개.
        
        Map<Integer,Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        int count = 0;
        
        for(int t:topping){ // 토핑을 다담아 중복 체크 
            right.put(t,right.getOrDefault(t,0) + 1);
        }
        
        for(int i=0; i<topping.length; i++){           
            int t = topping[i];            
            left.add(t); // 왼쪽에 넣기 시작
            
            right.put(t,right.get(t)-1);  // 왼쪽에 넣은거 개수 1개 제거
            
            if(right.get(t) == 0){ // 0 개수인 토핑 제거
                right.remove(t);
            }
            
            if(left.size() == right.size()){ // 사이즈 비교
                count++;
            }
        }
                
        return count;
    }
}