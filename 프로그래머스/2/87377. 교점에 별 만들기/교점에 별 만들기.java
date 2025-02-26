import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        // line 은 직선 들 Ax + By + C = 0
        // 교점이 포함된 사각형을 출력하라.
        // 교점은 *, 나머지는 .
        // 아 어려워.. 뭥미 ;;
       
        // 교점 좌표 저장
        List<int[]> points = new ArrayList<>();
        
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] point = getIntersection(line[i], line[j]); // 두 직선의 교점 구하기
                if (point != null) {
                    points.add(point);
                }
            }
        }
        
        // 좌표 범위 찾기
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        
        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }
        
        int width = maxX-minX+1;
        int height = maxY-minY+1;
        
        List<String> result = new ArrayList<>();
        
        for (int y = maxY; y >= minY; y--) {  
            StringBuilder row = new StringBuilder();
            for (int x = minX; x <= maxX; x++) {
                row.append('.');
            }
            
            for (int[] p : points) {
                if (p[1] == y) {
                    int xIndex = p[0] - minX; 
                    row.setCharAt(xIndex, '*');
                }
            }
            result.add(row.toString());
        }
        
        return result.toArray(new String[0]); // 리스트를 배열로 변환
    }
    
    // 두 직선의 교점 구하는 함수
    private int[] getIntersection(int[] l1, int[] l2) {
        long A1 = l1[0], B1 = l1[1], C1 = l1[2];
        long A2 = l2[0], B2 = l2[1], C2 = l2[2];

        long deno = A1 * B2 - A2 * B1; // 분모

        if (deno == 0) return null; // 평행한 경우

        long xNum = B1 * C2 - B2 * C1; // x의 분자
        long yNum = A2 * C1 - A1 * C2; // y의 분자

        if (xNum % deno != 0 || yNum % deno != 0) return null; // 정수 좌표가 아닐 경우 제외

        return new int[]{(int)(xNum / deno), (int)(yNum / deno)};
    }
    
}