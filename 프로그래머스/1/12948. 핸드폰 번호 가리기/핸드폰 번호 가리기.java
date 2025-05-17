class Solution {
    public String solution(String phone_number) {
        int n = phone_number.length();
        int end = n - 4;

        String stars = "*".repeat(end);
        String lastFour = phone_number.substring(end);

        return stars + lastFour;
    }
}
