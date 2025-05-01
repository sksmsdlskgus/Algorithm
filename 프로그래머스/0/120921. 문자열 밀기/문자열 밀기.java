class Solution {
    public int solution(String A, String B) {
        
        if (A.equals(B)) {
            return 0;
        }

        for (int i = 0; i < A.length(); i++) {

            A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);         
            if (A.equals(B)) {
                return i + 1; 
            }
        }

        return -1;
    }
}
