import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // bridge_length =  최대 올라갈 수 있는 트럭의 수 
        // weight 이하의 무게까지 다리가 견딜 수 있다.
        // truck_weights = 트럭 별 무게
        // 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    currentWeight += truck;
                    time++;
                    break;
                }

                if (bridge.size() == bridge_length) {
                    currentWeight -= bridge.poll();
                }

                if (currentWeight + truck <= weight) {
                    bridge.add(truck);
                    currentWeight += truck;
                    time++;
                    break;
                } else {
                    bridge.add(0);
                    time++;
                }
            }
        }

        time += bridge_length;
        return time;
    }
}
