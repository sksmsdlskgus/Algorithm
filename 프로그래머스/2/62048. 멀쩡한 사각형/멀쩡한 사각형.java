class Solution {
    public long solution(int w, int h) {
        // 사각형 넓이 x*y 
        // 못쓰는 사각형 = 직사각형 대각선 방향으로 자른 직선과 맞닿아 있는 사각형
        // 꼭짓점 (0,0)에서부터 (h,w)으로 이어진 직선
        // (x*y)-못쓰는 사각형= return
        
        long W = (long) w; // int 범위 초과 가능성있으므로 long으로 해라..
        long H = (long) h;
        
        long gcd = getGCD(W,H);
    
        return W*H-(W+H-gcd);
    }
    
    private long getGCD (long a, long b){ // 최대 공약수 구하기
        if(b==0) return a;
        return getGCD(b, a % b);
    }
    
}