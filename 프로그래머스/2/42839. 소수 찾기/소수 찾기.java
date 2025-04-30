import java.util.HashSet;
import java.util.Iterator;

class Solution {
    HashSet<Integer> numberset = new HashSet<>();
    
    public int solution(String numbers) {
        // 각 조합하기 -> 재귀
        // HashSet 사용 -> 중복 제거 
        // 소수는 2로 나눠서 나머지 값이 0이 아닐경우 -> 그걸 카운트
        int count = 0;
        
        recursive("",numbers);
        System.out.println(numberset);
        
        Iterator<Integer> it = numberset.iterator();
        while(it.hasNext()){
            int number = it.next();
            if(isPrime(number)){
                count++;
            }
        }
        
        return count;
    }
    
    // 재귀 부분
    private void recursive(String combi, String others){
        if(!combi.isEmpty()){
            numberset.add(Integer.valueOf(combi));
        }
        
        for(int i=0; i<others.length(); i++){
            recursive(combi+ others.charAt(i),others.substring(0,i)+others.substring(i+1));
        }
        
    }
    
    // 소수 판단 부분
    private boolean isPrime(int num){
        if(num < 2) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }
        
}