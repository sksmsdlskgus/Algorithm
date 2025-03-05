import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 리스트에 담을 것 분할
        s = s.substring(2,s.length()-2);
        String[] groups  = s.split("\\},\\{");
        
        List<List<Integer>> list = new ArrayList<>(); // 리스트로 담을것 선언
        
        for(String group : groups){
            String[] values = group.split(",");
            List<Integer> innerList = new ArrayList<>();
            
            for(String value : values){
                innerList.add(Integer.parseInt(value));
            }
            
            list.add(innerList);
        }
        
        list.sort(Comparator.comparingInt(List :: size)); // 사이즈별로 정렬 (짧부터)
        
        List<Integer> result = new ArrayList<>(); // 결과 값 리스트
        
        for(List<Integer> nums : list){
            for(int num : nums){
                if(!result.contains(num)){
                    result.add(num);
                }
            }
        }

        return result.stream().mapToInt(i -> i).toArray(); // 배열로 전환
    }
}