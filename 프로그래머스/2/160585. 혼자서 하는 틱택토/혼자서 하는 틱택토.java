import java.util.*;

class Solution {
    public int solution(String[] board) {
        // 선공 O, 후공 X, . 빈칸
        // 가로 세로 대각선으로 3개가 같은 표시가 만들어지면. 그 사람이 승리 , 게임 종료 
        // 9칸이 모두 차서 더이상 못할경우 -> 무승부로 종료 
        // 잘못안했으면 1, 아니면 0 을 return
        
        // X가 n개 있으면 O도 n개 이상 존재해야한다. 
        // O이랑 X 둘다 빙고가 될 수 없다. 
        // O이 빙고가 됐다면 X는 O의 개수보다 하나 적어야한다.
        // X가 빙고가 됐다면 O와 X의 개수는 똑같고 && O는 빙고가 안되어야 한다.
        // 9칸 다 .이어도 상관없다. (공격 시작 전이니)
        // 9칸 다 찼으면 -> O이 5개 X가 4개이고 && 둘다 빙고가 아니면 무승부 가능하다. 
        
        char[][] map = new char[3][3];
        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < 3; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') oCount++;
                else if (map[i][j] == 'X') xCount++;
            }
        }

        if (xCount > oCount || oCount - xCount > 1) return 0;

        boolean oWin = isWin(map, 'O');
        boolean xWin = isWin(map, 'X');

        // O와 X 모두 이겼으면 잘못된 상태
        if (oWin && xWin) return 0;

        // O가 이겼으면 → O가 한 수 더 많아야 함
        if (oWin && oCount != xCount + 1) return 0;

        // X가 이겼으면 → O와 X 개수 같아야 함
        if (xWin && oCount != xCount) return 0;

        return 1;
    }

    private boolean isWin(char[][] map, char player) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) return true;
        }

        // 세로
        for (int j = 0; j < 3; j++) {
            if (map[0][j] == player && map[1][j] == player && map[2][j] == player) return true;
        }

        // 대각선
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;

        return false;
    }
}