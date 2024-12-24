import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        // 폰켓몬 종류를 저장하기 위한 HashSet
        HashSet<Integer> uniqueTypes = new HashSet<>();

        // nums 배열의 모든 요소를 HashSet에 추가
        for (int num : nums) {
            uniqueTypes.add(num);
        }

        // N/2 마리의 폰켓몬을 선택할 수 있으므로 최대 선택 가능한 수는 nums.length / 2
        int maxSelectable = nums.length / 2;

        // 선택 가능한 최대 종류는 uniqueTypes.size()와 maxSelectable 중 최소값
        return Math.min(uniqueTypes.size(), maxSelectable);
    }
}
