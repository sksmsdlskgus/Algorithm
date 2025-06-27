class Solution {
    public long solution(int price, int money, int count) {
        long total = price * (long) count * (count + 1) / 2;
        long diff = total - money;
        return diff > 0 ? diff : 0;
    }
}