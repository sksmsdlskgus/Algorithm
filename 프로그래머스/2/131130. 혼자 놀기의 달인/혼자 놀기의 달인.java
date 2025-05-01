import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                int count = 0;
                int idx = i;

                // 한 그룹이 닫힐 때까지 계속 탐색
                while (!visited[idx]) {
                    visited[idx] = true;
                    idx = cards[idx] - 1;  
                    count++;
                }

                groupSizes.add(count);
            }
        }

        groupSizes.sort(Collections.reverseOrder());

        if (groupSizes.size() < 2) return 0;

        return groupSizes.get(0) * groupSizes.get(1);
    }
}
