import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수의 이름을 키로, 현재 등수를 값으로 저장하는 HashMap
         // 최종 순위를 반환
        HashMap<String, Integer> rankMap = new HashMap<>();
    
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        // callings 배열에 따라 순위 업데이트
        for (String calling : callings) {
            int currentRank = rankMap.get(calling); // 호출된 선수의 현재 등수
            if (currentRank > 0) { // 1등은 호출되지 않으므로 항상 currentRank > 0
                int previousRank = currentRank - 1; // 앞의 선수 등수
                
                // 현재 순위와 이전 순위 선수 이름
                String previousPlayer = players[previousRank];
                
                // 두 선수의 순위 교환
                players[previousRank] = calling;
                players[currentRank] = previousPlayer;
        
                rankMap.put(calling, previousRank);
                rankMap.put(previousPlayer, currentRank);
            }
        }

        return players;
    }
}
