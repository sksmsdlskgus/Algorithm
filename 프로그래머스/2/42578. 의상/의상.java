import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 매일 중복된 옷 금지
        // 종류별로 최대 １가지 의상만 
        // clothes ＝ 소유한 의상 ２차원 배열 
        
        int answer = 1;  // 서로다른 옷의조합의 수 최종 반환
        
        Map<String,Integer> haveClothes = new HashMap<>(); 
   
        for (String[] item : clothes) {
             String type = item[1];  // 옷의 종류
             haveClothes.put(type, haveClothes.getOrDefault(type, 0) + 1);
        }
        
        for (int count : haveClothes.values()){
            answer *= (count+1);
        }
     
        return answer-1;// 아무것도 안입었을때 !!
    }
}