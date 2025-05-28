class Solution {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m); // 최대공약수
        int lcm = (n * m) / gcd; // 최소공배수
        return new int[]{gcd, lcm};
    }

    // 유클리드 호제법
    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}
