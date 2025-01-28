class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // numer1 분자, denom1 분모 -> 첫번째 분수
        // numer2 분자, denom2 분모 -> 두번째 분수
        // 두분수 더해서 기약분수로 나타낸 후 , 분자와 분모를 순서대로 배열로 담아서 return해라
        int[] answer = new int[2]; 
        
        int number = ((numer1 * denom2) + (numer2 * denom1));
        int denom = ( denom1 * denom2);
        
        int gcd = getGCD(denom, number);
        
        number = number/gcd;
        denom = denom/gcd;
           
        answer[0] = number;
        answer[1] = denom;
        
        return answer;
    }
    
    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}