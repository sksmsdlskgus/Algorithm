import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        int x = 0;
        int y = 0;

        // 시작 위치 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        // 방향 설정
        Map<String, int[]> dirMap = new HashMap<>();
        dirMap.put("N", new int[]{-1, 0});
        dirMap.put("S", new int[]{1, 0});
        dirMap.put("W", new int[]{0, -1});
        dirMap.put("E", new int[]{0, 1});

        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];
            int dist = Integer.parseInt(split[1]);

            int dx = dirMap.get(dir)[0];
            int dy = dirMap.get(dir)[1];


            boolean isBlocked = false;

            for (int i = 1; i <= dist; i++) {
                int tx = x + dx * i;
                int ty = y + dy * i;

                // 경계 체크
                if (tx < 0 || ty < 0 || tx >= h || ty >= w) {
                    isBlocked = true;
                    break;
                }

                // 장애물 체크
                if (park[tx].charAt(ty) == 'X') {
                    isBlocked = true;
                    break;
                }
            }

            // 이동 가능한 경우에만 실제로 이동
            if (!isBlocked) {
                x += dx * dist;
                y += dy * dist;
            }
        }

        return new int[]{x, y};
    }
}
