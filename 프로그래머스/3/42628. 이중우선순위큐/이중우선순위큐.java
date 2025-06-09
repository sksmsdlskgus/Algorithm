import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>(); // 삭제 동기화용

        for (String op : operations) {
            String[] parts = op.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (cmd.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            } else if (cmd.equals("D")) {
                if (countMap.isEmpty()) continue;

                PriorityQueue<Integer> targetHeap = num == 1 ? maxHeap : minHeap;
                cleanUp(targetHeap, countMap);  // 이미 삭제된 값 제거

                if (!targetHeap.isEmpty()) {
                    int target = targetHeap.poll();
                    countMap.put(target, countMap.get(target) - 1);
                    if (countMap.get(target) == 0) {
                        countMap.remove(target);
                    }
                }
            }
        }

        cleanUp(minHeap, countMap);
        cleanUp(maxHeap, countMap);

        if (countMap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }

    private void cleanUp(PriorityQueue<Integer> heap, Map<Integer, Integer> countMap) {
        while (!heap.isEmpty() && !countMap.containsKey(heap.peek())) {
            heap.poll();
        }
    }
}
