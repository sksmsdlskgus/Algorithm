import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 완주하지 못한 선수의 이름을 return
        // 동명이인 존재
        String answer = "";
        Map<String,Integer> map = new HashMap<>();

        for(int i=0; i<participant.length; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        
        for(int i=0; i<completion.length; i++){
            map.put(completion[i],map.get(completion[i])-1);
            
            if(map.get(completion[i]) == 0){
                map.remove(completion[i]);
            }
        }
        
        for(String name: map.keySet()){
            answer = name;
        }
   
        return answer;
    }
}