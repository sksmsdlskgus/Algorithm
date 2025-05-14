import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger aBig = new BigInteger(a);
        BigInteger bBig = new BigInteger(b);
        BigInteger sum = aBig.add(bBig);
        return sum.toString();
    }
}
