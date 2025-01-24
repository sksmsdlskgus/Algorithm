import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // n = 전체 학생 수
        // lost = 도난당한 학생들의 번호 모음집
        // reserve = 여벌을 챙긴 학생들의 번호 모음집
        // 체육수업 들을 수 있는 학생의 최댓값 return  
        // 인덱스 앞뒤 사람만 해당 인덱스에게 빌려줄 수 있음
        
         // 여벌 체육복을 가진 학생 중 도난당한 학생을 제외
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        
        for (int r : reserve) {
            reserveSet.add(r);
        }
        
        for (int l : lost) {
            if (reserveSet.contains(l)) {
                reserveSet.remove(l); // 여벌 체육복이 있고, 빌려주기 X
            } else {
                lostSet.add(l); // 여벌 체육복이 없고, 도난 O
            }
        }
        
        // 빌려주는 로직
        for (int r : new HashSet<>(reserveSet)) { 
            if (lostSet.contains(r - 1)) { // 앞 번호 학생에게 빌려줌
                lostSet.remove(r - 1);
                reserveSet.remove(r);
            } else if (lostSet.contains(r + 1)) { // 뒷 번호 학생에게 빌려줌
                lostSet.remove(r + 1);
                reserveSet.remove(r);
            }
        }
        
        // 전체 학생 수에서 체육복을 못 받은 학생 수를 뺌
        return n - lostSet.size();
    }
}