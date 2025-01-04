import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 참가자 명단을 저장할 HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 명단을 HashMap에 추가
        for (String person : participant) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        // 완주자 명단을 HashMap에서 차감
        for (String person : completion) {
            map.put(person, map.get(person) - 1);
        }

        // 값이 0이 아닌 선수를 반환
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        // 모든 참가자가 완주한 경우 (문제 조건상 발생하지 않음)
        return "";
    }
}
