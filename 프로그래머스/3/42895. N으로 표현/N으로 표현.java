import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // 1 이상 9이하인 n
        // 최솟값이 8보다 크면 -1 return
        // 8개 까지만 사용해라
        // N를 사용해서 number로 만든 N의 개수 중 최솟값을 구해라 
        
        if(N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i=0; i<=8; i++){
            dp.add(new HashSet<>());
        }
        
        for(int i=1; i<=8; i++){
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatedN);
            
            for(int j=1; j<i; j++){
                for(int a: dp.get(j)){
                    for(int b: dp.get(i-j)){
                        dp.get(i).add(a-b);
                        dp.get(i).add(a+b);
                        dp.get(i).add(a*b);
                        if(b != 0)dp.get(i).add(a/b);
                    }
                }
            }
            if(dp.get(i).contains(number)) return i;
        }
            
        return -1;
    }
}