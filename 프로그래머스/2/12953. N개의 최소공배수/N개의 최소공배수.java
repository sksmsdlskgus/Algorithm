class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0]; 
        
        for (int i = 1; i < arr.length; i++) {
            lcm = lcm * arr[i] / getGCD(lcm, arr[i]);
        }

        return lcm; 
    }

    private int getGCD(int a, int b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}
