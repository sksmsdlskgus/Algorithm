// 지나간 길 중, 캐릭터가 "처음" 걸어본 길의 길이 return
// 좌표 넘어가면 무시 후, 다음 단계 진행
// U위 D아래 R오른쪽 L왼쪽 으로 한칸씩

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x=0;
        int y=0;
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});
        
        Set<String> edges = new HashSet<>();
        
        for(int i=0; i<dirs.length(); i++){
            char dir = dirs.charAt(i);
            int dx = x;
            int dy = y;
            int[] d = map.get(dir);
            
            int nx = x + d[0];
            int ny = y + d[1];
            
        
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            String a = x+","+y;
            String b = nx+","+ny;
            String e1 = a+"->"+b;
            String e2 = b+"->"+a;
            
            if(!edges.contains(e1) && !edges.contains(e2)){
                edges.add(e1);
                edges.add(e2);
                answer++;
            }
            
            x=nx;
            y=ny;
            
            
        }
        
        return answer;
    }
}