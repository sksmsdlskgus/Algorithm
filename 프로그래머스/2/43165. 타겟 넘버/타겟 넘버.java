import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        // 사용가능한 숫자 배열 numbers
        // 타겟 넘버 target
        // 사용가능한 숫자들로 더하거나 빼서 타겟넘버로 만들어라.
        int[] answer = {0};  
        
        // DFS 함수 호출 시작할때 인덱스 0, 합 0
        dfs(numbers, target, 0, 0, answer);
        
        return answer[0];
    }

    private void dfs(int[] numbers, int target, int index, int currentSum, int[] answer) {
        // numbers 안에있는 모든 숫자 돌았을때임 
        if (index == numbers.length) {
            // 같으면 카운트 증가
            if (currentSum == target) {
                answer[0]++;
            }
            return;
        }
        
        // 더하거나 빼는 두 가지 경우
        // +
        dfs(numbers, target, index + 1, currentSum + numbers[index], answer);
        
        // -
        dfs(numbers, target, index + 1, currentSum - numbers[index], answer);
    }
}