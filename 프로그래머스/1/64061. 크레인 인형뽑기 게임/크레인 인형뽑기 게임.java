import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        // board = 인형이 담긴 배열, moves = 뽑아야할 칸의위치 
        // 터진 인형의 개수 return
        // 만약 result에서 담을때? 전의 인덱스가 같은 숫자면? 둘다 pop 
        // 그리고 값이 0이 아니면?

        Stack<Integer> result = new Stack<>();
        int count = 0;

        Stack<Integer>[] stacks = new Stack[board[0].length];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    stacks[j].push(board[i][j]);
                }
            }
        }

        for (int move : moves) {
            int col = move - 1;
            if (!stacks[col].isEmpty()) {
                int doll = stacks[col].pop();

                if (!result.isEmpty() && result.peek() == doll) {
                    result.pop();
                    count += 2;
                } else {
                    result.push(doll);
                }
            }
        }

        return count;
    }
}